# TercerEntregable

Este es el Readme del tercer entregable, en este documento detallo la forma para encontrar mas rápido la información a evaluar...

* Captura de pantalla de proyecto generado por Spring Initializr: Esta prueba se encuentra en la carpeta "Prueba_SpringInicializr" de este repositorio
* Dockerfile desplegando en el contenedor: Nos comentaron que se tomaria como bueno con tan solo tener el archivo "DockerFile", 
  ya que por motivos de administracion del equipo no fue posible correr el programa Docker, este archivo se encuentra en la siguiente direccion de este repositorio: 
  "Proyecto/Tercerentregable/Dockerfile"
* Archivo application.properties con el formato correcto: Solo se hizo uso de la configuración de conexion con MongoDB
* Estructura del proyecto correcta: Se implementó el patron de arquitectura MVC separando por paquetes -> controller, dao, dto, entidad, services, utils
* Colección de Postman para consumir la API generada: esta se encuentra dentro de la direccion: "/ColeccionPostman" de este repositorio

*** Los puntos siguientes que ya son mas referenciados en código, los podemos encontrar dentro del proyecto haciendo uso del buscador general de IntelliJIdea,
 este obtenido con la convinacion de teclas: Ctrl+Shift+F ***
 
  * Consumo de API pública usando RestTemplate: Api_jsonplaceholder
  * Conversión del contenido consumido usando JAXB o Jackson: Jackson - ObjectMapper
 
 *** API generada por Spring MVC con un endpoint de cada tipo, puedes encontrar los comentarios buscando: ***
 
    * API generada por Spring MVC con un endpoint de cada tipo: POST - crearusuario
    * API generada por Spring MVC con un endpoint de cada tipo: POST - login de usuario
    * API generada por Spring MVC con un endpoint de cada tipo: GET - obtenerusuarios
    * API generada por Spring MVC con un endpoint de cada tipo: PUT - actualizarcontrasenia
    * API generada por Spring MVC con un endpoint de cada tipo: GET - obtenerUsuarioPorId
    * API generada por Spring MVC con un endpoint de cada tipo: DELETE - borrarUsuarioPorId
    * API generada por Spring MVC con un endpoint de cada tipo: GET - apiPublica
    
 * Creación de enlace con MongoDB usando Spring Data JPA
 * Uso de MongoTemplate
 
 *** Lectura de MongoDB usando MongoTemplate, puedes buscar estos comentarios: ***
 
      * Lectura de MongoDB usando MongoTemplate: mongoTemplate.findAll()
      * Lectura de MongoDB usando MongoTemplate: mongoTemplate.findOne()
      
 * Escritura en MongoDB usando MongoTemplate: mongoTemplate.save()
 * Actualización en MongoDB usando MongoTemplate: mongoTemplate.updateFirst()
 * Borrado en MongoDB usando MongoTemplate: mongoTemplate.remove()
 
 *** Prueba unitaria de cada endpoint de la API, puedes buscar los siguientes comentarios: ***
 
     * Prueba unitaria de cada endpoint de la API - Crear Usuario
     * Prueba unitaria de cada endpoint de la API - Login
     * Prueba unitaria de cada endpoint de la API - Obtener Usuarios
     * Prueba unitaria de cada endpoint de la API - Actualizar Contrasenia
     * Prueba unitaria de cada endpoint de la API - Busca Usuario por Id
     * Prueba unitaria de cada endpoint de la API - Eliminar Usuario por Id
     * Prueba unitaria de cada endpoint de la API - Consumo de api publica por restTemplate
 
 *** Prueba unitaria de cada operación CRUD ** //Para este caso, hice pruebas directamente con el arhcivo UserDAO que usa mongoTemplate, busca los siguientes       comentarios: ***
 
    * Prueba unitaria de cada operación CRUD - mongoTemplate.save
    * Prueba unitaria de cada operación CRUD - mongoTemplate.remove
    * Prueba unitaria de cada operación CRUD - mongoTemplate.findAll
    * Prueba unitaria de cada operación CRUD - mongoTemplate.updateFirst
    
     *** Aunque si lo que se necesitas no son las pruebas con la clase mongoTemplate directamente, puedes buscar las pruebas con los servicios, busca los siguientes comentarios: ***
     
            * Prueba unitaria de cada operación CRUD: CreateUserService - save()
            * Prueba unitaria de cada operación CRUD: LoginUserService - findOne()
            * Prueba unitaria de cada operación CRUD: CambioContraseniaUserService - updateFirst()
            * Prueba unitaria de cada operación CRUD: ObtenerTodosUsuariosService - findAll()
            * Prueba unitaria de cada operación CRUD: BuscarUsuarioPorIdUserService - FindOne()
            * Prueba unitaria de cada operación CRUD: EliminarUsuarioPorIdUserService - remove()
 
 *** Uso de Mockito en cada prueba, puedes buscar los siguientes comentarios: ***
    * Uso de Mockito en cada prueba - UserServiceTest - Se mockean: uSerDAO y UserServiceImpl
    * Uso de Mockito en cada prueba - UserControllerTest - Se mockean: UserServiceImpl, UserDAO, ObjectMapper
 
 * Generación de logs por prueba: Cada prueba unitaria contiene una breve descripcion en cada linea usada //Nos comentaron que este punto era como domentar con logs                                                                                                                cada paso de la prueba
 
 *** Pruebas para Happy Path: Puedes buscar los comentarios: ***
 
        * Pruebas para Happy Path - UserServiceTest - CreateUserService
        * Pruebas para Happy Path - UserServiceTest - LoginService
        * Pruebas para Happy Path - UserServiceTest - CambioContraseniaService
        * Pruebas para Happy Path - UserServiceTest - ObtenerUsuariosService
        * Pruebas para Happy Path - UserServiceTest - BusquedaUsuarioService
        * Pruebas para Happy Path - UserServiceTest - EliminaUsuarioService
        * Pruebas para Happy Path - UserServiceTest - ConsumeApiPublicaService

        * Pruebas para Happy Path - UserSControllerTest - CreateUserController
        * Pruebas para Happy Path - UserControllerTest - LoginUserController
        * Pruebas para Happy Path - UserControllerTest - ObtenerUsuariosUserController
        * Pruebas para Happy Path - UserControllerTest - ActualizarContraseniaUserController
        * Pruebas para Happy Path - UserControllerTest - BuscaUsuarioPorIdUserController
        * Pruebas para Happy Path - UserControllerTest - EliminaUsuarioPorIdUserController
        * Pruebas para Happy Path - UserControllerTest - ConsumoDeApiPublicaUserController
 
 ** Pruebas para cada Edge Case, puedes buscar los siguientes comentarios: **
        * Edge Case - CreateUserService - CuerpoEntradaNulo
        * Edge Case - LoginUserService - ParametrosDeEntradaNulos
        * Edge Case - LoginUserService - ParametroDeEntradaNuloYVacio
        * Edge Case - CambioDeContraseniaUserService - ParametrosDeEntradaNulos
        * Edge Case - CambioDeContraseniaUserService - ParametroDeEntradaNuloYVacio
        * Edge Case - ObtenerUsuariosUserService - UsuariosNoExistentesErrorControlado
        * Edge Case - ObtenerUsuarioPorIdUserService - ValidaParametroNulo&Vacio
        * Edge Case - EliminacionDeUsuarioPorIdUserService - ValidaParametroNulo&Vacio
        * Edge Case - ConsumeApiPublica - ValidaParametroUrlNulo&Vacio

        * Edge Case - CrearUsuarioController - ValidaRequestBodyNulo
        * Edge Case - LoginController - ValidaParametrosNulosOVacios
        * Edge Case - LoginController - UsuarioNoExistente
        * Edge Case - ObtenerUsuariosController - RespuestaErroneaControlada
        * Edge Case - ActualizarContraseniaController - ValidaParametroNuloOVacio
        * Edge Case - ActualizarContraseniaController - UsuarioNoExistente
        * Edge Case - BuscaUsuarioporIdController - ValidaParametroNuloOVacio
        * Edge Case - BuscaUsuarioporIdController - RespuestaErroneaControlada
        * Edge Case - EliminaUsuarioPorIdController - ValidaParametroNuloOVacio
        * Edge Case - EliminaUsuarioPorIdController - RespuestaErroneaControlada
        * Edge Case - ConsumeApiPublicaController - RespuestaErroneaControlada
 
 
 
 
 
 
 
 
