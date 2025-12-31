-- Script para desbloquear cuentas administrativas de Oracle
-- Este script debe ser ejecutado como SYSDBA

-- Desbloquear cuenta SYSTEM
ALTER USER SYSTEM ACCOUNT UNLOCK;

-- Cambiar contraseña de SYSTEM a "oracle"
ALTER USER SYSTEM IDENTIFIED BY oracle;

-- Desbloquear cuenta SYS si es necesario
ALTER USER SYS ACCOUNT UNLOCK;

-- Cambiar contraseña de SYS a "oracle"
ALTER USER SYS IDENTIFIED BY oracle;

-- Desbloquear otras cuentas comunes
ALTER USER ANONYMOUS ACCOUNT UNLOCK;
ALTER USER APEX_PUBLIC_USER ACCOUNT UNLOCK;
ALTER USER APEX_040200 ACCOUNT UNLOCK;
ALTER USER APEX_REST_PUBLIC_USER ACCOUNT UNLOCK;
ALTER USER FLOWS_FILES ACCOUNT UNLOCK;
ALTER USER HR ACCOUNT UNLOCK;
ALTER USER MDSYS ACCOUNT UNLOCK;
ALTER USER OUTLN ACCOUNT UNLOCK;

-- Confirmar cambios
COMMIT;

-- Verificar estado de la cuenta SYSTEM
SELECT username, account_status FROM dba_users WHERE username = 'SYSTEM';

-- Verificar estado de la cuenta SYS
SELECT username, account_status FROM dba_users WHERE username = 'SYS';

-- Salir
exit; 