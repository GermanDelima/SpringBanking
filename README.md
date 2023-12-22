Descripción del Proyecto:

El proyecto consiste en el desarrollo de un simulador de acciones que replicará un sistema de Homebanking denominado "Spring Banking". Se trabajarán sobre tres entidades principales: Usuarios, Cuentas (ya sea cuenta corriente o caja de ahorro) y Transferencias.

Requisitos Técnicos:

Utilizar Java 11 o 17 con Maven.
Conexión a la Base de Datos mediante JDBC.
Implementar Spring JPA y Hibernate para el manejo de la persistencia.
Configurar en el application.properties la conexión y las configuraciones (incluyendo ddl.auto=update).

Arquitectura del Proyecto:

Se trabajará sobre un Sistema Monolítico con las siguientes capas:


Controllers
Services
Mappers
DTO (Data Transfer Objects)
Entities
Repositories

Entidades y Relaciones:


Usuario:
Atributos: id, nombreUsuario, email, contraseña, dni, fecha_nacimiento, domicilio (dirección), lista de cuentas (List<Cuenta>).
Cuenta:
Atributos: id, nombre, cbu, alias, monto, dueño (usuario dueño de la cuenta).
Transferencias:
id, monto, cuentaOrigen, cuentaDestino, fecha

Tareas a Realizar:


Desarrollar un CRUD para cada entidad (Usuarios, Cuentas, y Transferencias).
Establecer las relaciones entre entidades, garantizando la integridad de los datos.
