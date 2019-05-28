/*
    Executar com privilégios DBA para criar o usuário que será usado pela aplicação, se necessário
*/

alter session set "_ORACLE_SCRIPT"=true;
CREATE USER BD1711006 IDENTIFIED BY occupyMars;
GRANT CONNECT, RESOURCE TO BD1711006;
GRANT CREATE SESSION TO BD1711006;
GRANT UNLIMITED TABLESPACE TO BD1711006;
