
Para llevar a cabo el proyecto, desarrollé un simulador de acciones denominado "Spring Banking", replicando un sistema de homebanking. El proyecto se centró en tres entidades clave: Usuarios, Cuentas (corriente o caja de ahorro), y Transferencias.

Primero, utilicé Java 11 junto con Maven para gestionar las dependencias del proyecto. Me aseguré de establecer la conexión a la base de datos a través de JDBC, y configuré correctamente el archivo application.properties, donde incluí las propiedades necesarias para que Spring JPA e Hibernate gestionaran la persistencia. Entre las configuraciones, habilité la opción ddl.auto=update para que las entidades se generaran y actualizaran de forma automática en la base de datos.

La arquitectura del sistema fue diseñada como un monolito con varias capas, donde implementé Controllers, Services, Mappers, DTOs, Entities y Repositories, para separar correctamente las responsabilidades y asegurar un código limpio y mantenible.

Trabajé en las tres entidades principales. Para Usuario, definí atributos como el id, nombreUsuario, email, contraseña, dni, fecha_nacimiento, domicilio, y una lista de cuentas asociadas. La entidad Cuenta incluyó el id, nombre, cbu, alias, monto y la relación con su dueño (un objeto de tipo Usuario). Finalmente, para Transferencias, trabajé con los atributos id, monto, cuentaOrigen, cuentaDestino y fecha.

Desarrollé un CRUD completo para cada una de estas entidades, permitiendo crear, leer, actualizar y eliminar usuarios, cuentas y transferencias. Además, establecí las relaciones necesarias entre las entidades, implementando correctamente las asociaciones entre ellas para garantizar la integridad de los datos en todo momento.
