# Aplicación y servicio REST

La EETAC ha encargado el desarrollo de una aplicación para gestionar una flota de drones, dirigida a los estudiantes de DSA. La aplicación debe permitir realizar diversas operaciones clave para la gestión eficiente de los drones y pilotos.

Operaciones:
- Añadir un Nuevo Dron, atributos: Identificador, nombre, fabricante, modelo.
- Añadir un Nuevo Piloto, atributos: Identificador, nombre, apellidos.
- Listado de Drones por Horas de Vuelo (Descendente): Permite ver los drones ordenados según las horas de vuelo acumuladas.
- Listado de Pilotos por Horas de Vuelo (Descendente): Muestra los pilotos ordenados según las horas de vuelo acumuladas.
- Guardar un Dron en Almacén para Mantenimiento: Almacena un dron en el almacén, gestionando la proximidad a la puerta.
- Reparar/Mantener un Dron en Almacén: Realiza tareas de mantenimiento en el dron más cercano a la puerta del almacén y lo pone disponible para su uso.
- Añadir una Reserva para un Plan de Vuelo: Crea una reserva de plan de vuelo con detalles como identificador de dron, fecha, duración estimada, coordenadas de inicio y destino, y piloto asignado.
- Listado de Reservas Asignadas a un Piloto: Muestra las reservas de plan de vuelo asignadas a un piloto específico.
- Listado de Planes de Vuelo Asignados a un Dron: Visualiza los planes de vuelo asignados a un dron en particular.

Implementación y Estructura del Código

  Parte I:
- Identificar las entidades de información y sus propiedades.
- Interfaz Java: Define métodos para cada operación descrita anteriormente.
- Fachada (Patrón de Diseño Singleton): Incluye trazas de log utilizando Log4J para registrar parámetros y eventos clave.
- Test (JUNIT): Implementa pruebas unitarias para verificar el correcto funcionamiento de las operaciones de la fachada.

  Parte II
- Definición del Servicio REST: Define rutas y operaciones, utiliza DTOs (Objetos de Transferencia de Datos) y retorna respuestas con códigos de estado adecuados para cada operación.
- Implementación del Servicio REST: Construye un servicio REST utilizando el componente Java desarrollado anteriormente, asegura que todas las operaciones sean accesibles a través de endpoints RESTful y maneja correctamente la comunicación cliente-servidor utilizando Retrofit.
