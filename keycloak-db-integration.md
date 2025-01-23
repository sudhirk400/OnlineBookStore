Setup PostgreSQL database for keycloak
***********************************************************************************
Open PostgreSQL command prompt and run the commands to
create a database
create a database user
grant permissions of the newly created user to the newly created database.

Run below on sql command line or use pgAdmin

create database keycloak_db;
create user keycloak_user with password 'keycloak123';
grant all privileges on database keycloak_db to keycloak_user; 
ALTER ROLE keycloak_user
	SUPERUSER
	CREATEDB
	CREATEROLE
	REPLICATION
	BYPASSRLS;

Configure Keycloak to use the PostgreSQL database
***********************************************************************************
Add below database configuration in the conf/keycloak.conf file.  

db=postgres
db-url=jdbc:postgresql://localhost:5432/keycloak_db
db-username=keycloak_user
db-password=keycloak123
db-schema=public
