//Importa las funciones neon y el elemento neonConfig desde serverless
import { neon, neonConfig } from "@neondatabase/serverless";

// Configurar neon para manejar mejor los errores y reintentos
neonConfig.fetchOptions = {
  // Aumentar el tiempo de espera para evitar timeouts
  keepalive: true,
  cache: "no-store",
};

// Configuración para reintentos
const MAX_RETRIES = 5;
const INITIAL_BACKOFF_MS = 1000;

// Crear un cliente neon con una función personalizada para manejar errores
const createNeonClient = () => {
  const client = neon(process.env.DATABASE_URL!);
  return client;
};

// Crear un cliente con manejo de errores mejorado
const sql = createNeonClient();

// Caché en memoria para reducir consultas
const queryCache = new Map();
const CACHE_TTL = 30000; // 30 segundos

// Función para limpiar la caché
export function clearCache() {
  queryCache.clear();
}

// Función para manejar reintentos con backoff exponencial
async function executeWithRetry(
  fn: () => Promise<any>,
  maxRetries = MAX_RETRIES,
  initialBackoff = INITIAL_BACKOFF_MS,
) {
  let retryCount = 0;

  while (true) {
    try {
      return await fn();
    } catch (error: any) {
      const errorMessage = String(error);
      const isTooManyRequests =
        errorMessage.includes("Too Many") ||
        errorMessage.includes("429") ||
        errorMessage.includes("rate limit") ||
        errorMessage.includes("Unexpected token");

      if (isTooManyRequests && retryCount < maxRetries) {
        retryCount++;
        const backoffTime = initialBackoff * Math.pow(2, retryCount - 1);
        console.log(
          `Reintentando en ${backoffTime}ms (intento ${retryCount} de ${maxRetries})`,
        );
        await new Promise((resolve) => setTimeout(resolve, backoffTime));
        continue;
      }

      throw error;
    }
  }
}

export async function executeQuery(
  text: string,
  params?: any[],
  useCache = true,
) {
  try {
    // Para operaciones de escritura, nunca usar caché
    const isWriteOperation =
      text.trim().toUpperCase().startsWith("INSERT") ||
      text.trim().toUpperCase().startsWith("UPDATE") ||
      text.trim().toUpperCase().startsWith("DELETE");

    if (isWriteOperation) {
      useCache = false;
    }

    // Generar una clave de caché basada en la consulta y los parámetros
    const cacheKey = useCache
      ? `${text}-${JSON.stringify(params || [])}`
      : null;

    // Verificar si tenemos un resultado en caché
    if (cacheKey && queryCache.has(cacheKey)) {
      const { result, timestamp } = queryCache.get(cacheKey);
      const now = Date.now();

      // Usar el resultado en caché si no ha expirado
      if (now - timestamp < CACHE_TTL) {
        return result;
      } else {
        // Eliminar la entrada expirada
        queryCache.delete(cacheKey);
      }
    }

    // Ejecutar la consulta con reintentos
    const result = await executeWithRetry(async () => {
      return await sql.query(text, params || []);
    });

    // Determinar rowCount
    let rowCount = 0;
    let rows = [];

    if (Array.isArray(result)) {
      rows = result;
      rowCount = result.length;
    } else if (result && typeof result === "object") {
      if ("rows" in result) {
        rows = result.rows;
        rowCount = rows.length;
      }
      if ("rowCount" in result) {
        rowCount = result.rowCount;
      }
    }

    // Para operaciones de escritura, si no podemos determinar rowCount, asumimos 1
    if (isWriteOperation && rowCount === 0) {
      rowCount = 1;
    }

    const processedResult = { rows, rowCount };

    // Guardar en caché si es una consulta SELECT y useCache es true
    if (cacheKey && text.trim().toUpperCase().startsWith("SELECT")) {
      queryCache.set(cacheKey, {
        result: processedResult,
        timestamp: Date.now(),
      });
    }

    return processedResult;
  } catch (error) {
    console.error("Error final al ejecutar consulta:", error);
    throw error;
  }
}

// Helper function to convert Oracle/SQL style parameters (:param) to pg-style ($1, $2, etc)
export function convertParams(query: string, params: Record<string, any>) {
  const paramValues: any[] = [];
  let paramCount = 0;

  // Reemplazar los parámetros nombrados con parámetros posicionales
  const convertedQuery = query.replace(/:(\w+)/g, (match, paramName) => {
    if (params[paramName] === undefined) {
      console.warn(
        `Parámetro '${paramName}' no encontrado en los parámetros proporcionados`,
      );
      return "NULL";
    }

    paramCount++;
    paramValues.push(params[paramName]);
    return `$${paramCount}`;
  });

  return {
    query: convertedQuery,
    params: paramValues,
  };
}
