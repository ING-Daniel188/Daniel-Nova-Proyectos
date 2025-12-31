import { NextResponse } from "next/server"; 
import { setupDatabase } from "@/lib/db-setup"; // Importa función que realiza la configuración inicial de la base de datos
/**
 * GET
 * Realiza la configuración inicial de la base de datos e indica si la conexión fue exitosa o no.
 */
export async function GET() {
  try {
    const result = await setupDatabase();

    if (result.success) {
      return NextResponse.json({
        message: "Database setup completed successfully",
      });
    } else {
      return NextResponse.json(
        { message: "Database setup failed", error: result.error },
        { status: 500 },
      );
    }
  } catch (error) {
    console.error("Error in setup-db route:", error);
    return NextResponse.json(
      { message: "Internal server error", error },
      { status: 500 },
    );
  }
}
