# Guía de Instalación - Sistema de Gestión de Restaurante

Este documento detalla los pasos necesarios para instalar y configurar el Sistema de Gestión de Restaurante con Oracle 11g Express Edition.

## Requisitos Previos

1. Python 3.6 o superior
2. Oracle 11g Express Edition instalado en el equipo o accesible desde la red
3. Bibliotecas cliente de Oracle (ver instrucciones a continuación)

## Instalación de Dependencias Python

Para instalar las dependencias necesarias, ejecute:

```bash
pip install -r requirements.txt
```

## Instalación de Oracle Client (Recomendado)

Para que la aplicación funcione de manera óptima, se recomienda instalar las bibliotecas cliente de Oracle. Estas permiten usar el modo "thick" de conexión, que es más compatible con Oracle 11g Express Edition.

### Windows

1. Descargue "Instant Client Basic" y "Instant Client SDK" desde el sitio web de Oracle:
   https://www.oracle.com/database/technologies/instant-client/winx64-64-downloads.html

2. Extraiga los archivos descargados en una carpeta, por ejemplo: `C:\oracle\instantclient_19_9`

3. Agregue la carpeta a la variable de entorno PATH:
   - Panel de Control > Sistema > Configuración avanzada del sistema > Variables de entorno
   - Editar la variable PATH y agregar la ruta: `C:\oracle\instantclient_19_9`

4. Reinicie el sistema o la línea de comandos para que los cambios surtan efecto

### Linux

1. Descargue "Instant Client Basic" y "Instant Client SDK" para su distribución:
   https://www.oracle.com/database/technologies/instant-client/linux-x86-64-downloads.html

2. Instale los paquetes según su distribución:

   Para Debian/Ubuntu:
   ```bash
   sudo apt-get install alien libaio1
   sudo alien -i oracle-instantclient*-basic-*.rpm
   sudo alien -i oracle-instantclient*-devel-*.rpm
   ```

   Para RedHat/CentOS:
   ```bash
   sudo yum install oracle-instantclient*-basic-*.rpm
   sudo yum install oracle-instantclient*-devel-*.rpm
   ```

3. Configure variables de entorno:
   ```bash
   echo "export LD_LIBRARY_PATH=/usr/lib/oracle/18.5/client64/lib:\$LD_LIBRARY_PATH" >> ~/.bashrc
   source ~/.bashrc
   ```

### macOS

1. Descargue "Instant Client Basic" y "Instant Client SDK":
   https://www.oracle.com/database/technologies/instant-client/macos-intel-x86-downloads.html

2. Extraiga los archivos a una carpeta, por ejemplo: `/opt/oracle/instantclient_19_8`

3. Configure las variables de entorno:
   ```bash
   echo "export DYLD_LIBRARY_PATH=/opt/oracle/instantclient_19_8:\$DYLD_LIBRARY_PATH" >> ~/.zshrc
   echo "export PATH=/opt/oracle/instantclient_19_8:\$PATH" >> ~/.zshrc
   source ~/.zshrc
   ```

## Modo Thin (Alternativa)

Si no puede instalar Oracle Client, la aplicación intentará utilizar el modo "thin" de conexión. Este modo puede no ser compatible con Oracle 11g, pero puede funcionar para versiones más recientes.

## Ejecución de la Aplicación

Para ejecutar la aplicación, utilice:

```bash
python run.py
```

## Solución de Problemas

### Error: "connections to this database server version are not supported by python-oracledb in thin mode"

Este error indica que el modo "thin" de conexión no es compatible con su versión de Oracle. Para solucionar este problema:

1. Instale Oracle Client como se indica en este documento
2. Verifique que la variable PATH (Windows) o LD_LIBRARY_PATH (Linux/macOS) incluya la ruta correcta al cliente Oracle
3. Reinicie la aplicación

### Error de Acceso o Credenciales

Si aparecen errores relacionados con credenciales:

1. Verifique que el usuario y contraseña sean correctos
2. Compruebe que el servicio Oracle está en ejecución
3. Confirme que el nombre del servicio es correcto (por defecto "XE" para Oracle Express Edition)

### Modo de Depuración

Si no puede establecer conexión con la base de datos, puede utilizar el botón "Depuración" para probar la interfaz sin conectarse realmente a Oracle. 