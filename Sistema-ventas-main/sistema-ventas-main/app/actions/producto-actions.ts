//Este componente se ejecuta del lado del servidor
"use server";
//Importa la funcion executeQuery y converParamsdesde el componente db
import { convertParams, executeQuery } from "@/lib/db";
//Importa la funcion revalidatePath desde el componente cache
import { revalidatePath } from "next/cache";
//Se crea una interfaz para reprecentar el objeto Producto
export interface Producto {
  COD_PRO: string;
  DES_PRO: string;
  PRE_PRO: number;
  STO_PRO: number;
  SMI_PRO: number;
  UNI_PRO: string;
  UBI_PRO?: string;
  IMP_PRO?: string;
}
//Funcion para obtener la informacion de los productos
export async function obtenerProductos() {
  try {
    const result = await executeQuery(
      "SELECT * FROM PRODUCTO ORDER BY DES_PRO",
      [],
      false,
    );
    return { success: true, data: result.rows };
  } catch (error) {
    console.error("Error al obtener productos:", error);
    return { success: false, error };
  }
}
//Funcion para obtener la informacion de un producto por el codigo de producto
export async function obtenerProducto(codigo: string) {
  try {
    const { query, params } = convertParams(
      "SELECT * FROM PRODUCTO WHERE COD_PRO = :codigo",
      { codigo },
    );
    const result = await executeQuery(query, params);

    if (result.rows.length === 0) {
      return { success: false, error: "Producto no encontrado" };
    }

    return { success: true, data: result.rows[0] };
  } catch (error) {
    console.error("Error al obtener producto:", error);
    return { success: false, error };
  }
}
//Funcion para crear un producto
export async function crearProducto(producto: Producto) {
  try {
    const { query, params } = convertParams(
      `
      INSERT INTO PRODUCTO (
        COD_PRO, DES_PRO, PRE_PRO, STO_PRO, SMI_PRO, UNI_PRO, UBI_PRO, IMP_PRO
      ) VALUES (
        :codigo, :descripcion, :precio, :stock, :stockMinimo, :unidad, :ubicacion, :importacion
      )
    `,
      {
        codigo: producto.COD_PRO,
        descripcion: producto.DES_PRO,
        precio: producto.PRE_PRO,
        stock: producto.STO_PRO,
        stockMinimo: producto.SMI_PRO,
        unidad: producto.UNI_PRO,
        ubicacion: producto.UBI_PRO || null,
        importacion: producto.IMP_PRO || null,
      },
    );

    // Ejecutar la consulta y esperar a que se complete
    await executeQuery(query, params, false);

    // Verificar que el producto se haya creado correctamente
    const checkResult = await obtenerProducto(producto.COD_PRO);
    if (!checkResult.success) {
      throw new Error("No se pudo verificar la creación del producto");
    }

    // Revalidar la ruta para actualizar los datos
    revalidatePath("/productos");
    revalidatePath("/");

    return { success: true, data: checkResult.data };
  } catch (error) {
    console.error("Error al crear producto:", error);
    return { success: false, error: String(error) };
  }
}
//Funcion para actualizar un producto
export async function actualizarProducto(producto: Producto) {
  try {
    const { query, params } = convertParams(
      `
      UPDATE PRODUCTO SET 
        DES_PRO = :descripcion,
        PRE_PRO = :precio,
        STO_PRO = :stock,
        SMI_PRO = :stockMinimo,
        UNI_PRO = :unidad,
        UBI_PRO = :ubicacion,
        IMP_PRO = :importacion
      WHERE COD_PRO = :codigo
    `,
      {
        codigo: producto.COD_PRO,
        descripcion: producto.DES_PRO,
        precio: producto.PRE_PRO,
        stock: producto.STO_PRO,
        stockMinimo: producto.SMI_PRO,
        unidad: producto.UNI_PRO,
        ubicacion: producto.UBI_PRO || null,
        importacion: producto.IMP_PRO || null,
      },
    );

    const result = await executeQuery(query, params, false);

    if (result.rowCount === 0) {
      return { success: false, error: "Producto no encontrado" };
    }

    revalidatePath("/productos");
    revalidatePath("/");

    return { success: true };
  } catch (error) {
    console.error("Error al actualizar producto:", error);
    return { success: false, error: String(error) };
  }
}

export async function eliminarProducto(codigo: string) {
  try {
    const { query, params } = convertParams(
      "DELETE FROM PRODUCTO WHERE COD_PRO = :codigo",
      { codigo },
    );

    const result = await executeQuery(query, params, false);

    if (result.rowCount === 0) {
      return { success: false, error: "Producto no encontrado" };
    }

    revalidatePath("/productos");
    revalidatePath("/");

    return { success: true };
  } catch (error) {
    console.error("Error al eliminar producto:", error);
    return { success: false, error: String(error) };
  }
}
