//Importa la funcion executeQuery desde db 
import { executeQuery } from "./db";

// Function to set up the database schema, triggers, and stored procedures
export async function setupDatabase() {
  try {
    // Create audit table
    await executeQuery(`
      CREATE TABLE IF NOT EXISTS AUDITORIA (
        ID_AUDIT SERIAL PRIMARY KEY,
        TABLA VARCHAR(50) NOT NULL,
        OPERACION VARCHAR(10) NOT NULL,
        USUARIO VARCHAR(50) NOT NULL,
        FECHA TIMESTAMP NOT NULL,
        DATOS_ANTIGUOS JSONB,
        DATOS_NUEVOS JSONB
      )
    `);

    // Create function for audit logging
    await executeQuery(`
      CREATE OR REPLACE FUNCTION fn_registrar_auditoria()
      RETURNS TRIGGER AS $$
      DECLARE
        v_old_data JSONB;
        v_new_data JSONB;
      BEGIN
        IF (TG_OP = 'DELETE') THEN
          v_old_data = to_jsonb(OLD);
          v_new_data = null;
        ELSIF (TG_OP = 'UPDATE') THEN
          v_old_data = to_jsonb(OLD);
          v_new_data = to_jsonb(NEW);
        ELSIF (TG_OP = 'INSERT') THEN
          v_old_data = null;
          v_new_data = to_jsonb(NEW);
        END IF;

        INSERT INTO AUDITORIA (
          TABLA,
          OPERACION,
          USUARIO,
          FECHA,
          DATOS_ANTIGUOS,
          DATOS_NUEVOS
        ) VALUES (
          TG_TABLE_NAME,
          TG_OP,
          current_user,
          current_timestamp,
          v_old_data,
          v_new_data
        );
        RETURN NULL;
      END;
      $$ LANGUAGE plpgsql;
    `);

    // Create triggers for all tables
    const tables = [
      "DISTRITO",
      "PROVEEDOR",
      "VENDEDOR",
      "CLIENTE",
      "PRODUCTO",
      "FACTURA",
      "DETALLE_FACTURA",
      "ORDEN_COMPRA",
      "DETALLE_COMPRA",
      "ABASTECIMIENTO",
    ];

    for (const table of tables) {
      // Drop existing trigger if it exists
      await executeQuery(`
        DROP TRIGGER IF EXISTS trg_${table.toLowerCase()}_audit ON ${table}
      `);

      // Create new trigger
      await executeQuery(`
        CREATE TRIGGER trg_${table.toLowerCase()}_audit
        AFTER INSERT OR UPDATE OR DELETE ON ${table}
        FOR EACH ROW EXECUTE FUNCTION fn_registrar_auditoria()
      `);
    }

    // Create stored procedure for product restock
    await executeQuery(`
      CREATE OR REPLACE PROCEDURE sp_restock_producto(
        p_cod_pro CHAR(5),
        p_cantidad INTEGER
      )
      LANGUAGE plpgsql
      AS $$
      BEGIN
        UPDATE PRODUCTO
        SET STO_PRO = STO_PRO + p_cantidad
        WHERE COD_PRO = p_cod_pro;
        
        INSERT INTO AUDITORIA (
          TABLA,
          OPERACION,
          USUARIO,
          FECHA,
          DATOS_ANTIGUOS,
          DATOS_NUEVOS
        ) VALUES (
          'PRODUCTO',
          'RESTOCK',
          current_user,
          current_timestamp,
          NULL,
          jsonb_build_object('COD_PRO', p_cod_pro, 'CANTIDAD', p_cantidad)
        );
        
        COMMIT;
      END;
      $$;
    `);

    // Create function to calculate invoice total
    await executeQuery(`
      CREATE OR REPLACE FUNCTION fn_calcular_total_factura(p_num_fac VARCHAR(12))
      RETURNS DECIMAL
      LANGUAGE plpgsql
      AS $$
      DECLARE
        v_total DECIMAL;
        v_igv DECIMAL;
      BEGIN
        -- Get the total without tax
        SELECT COALESCE(SUM(CAN_VEN * PRE_VEN), 0)
        INTO v_total
        FROM DETALLE_FACTURA
        WHERE NUM_FAC = p_num_fac;
        
        -- Get the IGV percentage
        SELECT POR_IGV INTO v_igv
        FROM FACTURA
        WHERE NUM_FAC = p_num_fac;
        
        -- Calculate total with tax
        v_total := v_total * (1 + (v_igv / 100));
        
        RETURN v_total;
      END;
      $$;
    `);

    // Create function to check if product is below minimum stock
    await executeQuery(`
      CREATE OR REPLACE FUNCTION fn_verificar_stock_minimo()
      RETURNS TRIGGER AS $$
      BEGIN
        IF NEW.STO_PRO < NEW.SMI_PRO THEN
          INSERT INTO AUDITORIA (
            TABLA,
            OPERACION,
            USUARIO,
            FECHA,
            DATOS_ANTIGUOS,
            DATOS_NUEVOS
          ) VALUES (
            'PRODUCTO',
            'ALERTA',
            current_user,
            current_timestamp,
            NULL,
            jsonb_build_object(
              'COD_PRO', NEW.COD_PRO,
              'DES_PRO', NEW.DES_PRO,
              'STO_PRO', NEW.STO_PRO,
              'SMI_PRO', NEW.SMI_PRO,
              'MENSAJE', 'Producto por debajo del stock mínimo'
            )
          );
        END IF;
        RETURN NEW;
      END;
      $$ LANGUAGE plpgsql;
    `);

    // Create trigger for stock minimum check
    await executeQuery(`
      DROP TRIGGER IF EXISTS trg_verificar_stock_minimo ON PRODUCTO;
      
      CREATE TRIGGER trg_verificar_stock_minimo
      AFTER INSERT OR UPDATE ON PRODUCTO
      FOR EACH ROW
      EXECUTE FUNCTION fn_verificar_stock_minimo();
    `);

    console.log("Database setup completed successfully");
    return { success: true };
  } catch (error) {
    console.error("Error setting up database:", error);
    return { success: false, error };
  }
}
