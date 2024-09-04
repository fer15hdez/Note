# Structure of project
Controler: Is the layer(capa) of presentation. In this layer is where are the endpoint.    
Service: Is the layer of business logic.  
Domain (Dominio): Is this the layer where we place the POJO classes, meaning this is where our domain resides.  
Test: The place where the tests are.   

====================================

## Bean
Los **Bean** son los metodos que tienen un decorador de spring (ej. @service, @RestController, etc).  
@Bean("nameOfBean"): Permite agragar un nombre al Bean y con la anotacion @Qualifier("nameOfBean") llamar al Bean deseado.  
Es la forma que utiliza Spring Boot para denotar los componentes y asi poder utilizarlo en la inyeccion de dependencia.  
**@service** : Este decorador le indica a spring boot que debe tratar esta clase como un servicio, de esta 
forma spring gestionara automaticamente la creacion de esta clase cuando sea necesario.  
**@Autowired** : Esta anotacion es la encargada de crear la injeccion de dependencia.  Tambien llamada Field Injection, no es una buena practica, se 
recomienda hacer Contructor Injection.  
**@Qualifier**: Esta anotacion permite inyectar un Bean especifico, que pueden ser mas de un metodo dentro de la clase AppicationConfig y despues poderlo especificar desde la llamada de un servicio, etc.  
 **@Primary**: Permite determinar una prioridad donde existan mas de un Bean.  

 ### Inyeccion de dependencias (Bean)
 1- Constructor Injection -> Practica recomenda.  
 2- Field Injection  
 3- Setter Injecction  

 ### Property
 **@PropertySource("classpath:fileProperty.name")**: Permite definir un nuevo archivo donde se definan las nuevas propiedades del proyecto.  
 El archivo debe estar en la carpeta resource.  
 **@PropertySources**: Permite definir multiples archivos de configuracion.  
 @PropertySources({
    @PropertySource("classpath:fileProperty.name"),
    @PropertySource("classpath:fileProperty.name1"),
 })

 **@Value("${name.property}")**: Permite asociar el valor de la propiedad al campo de una clase en un servicio u otro componente. Spring Boot busca
  dentro de los archivos definido como archivos de configuracion (ej. mycustom.properties).  

====================================
  # PROFILES
  Los perfiles permiten hacer configuraciones para diferentes escenarios, ej. produccion, desarrollo, etc.  

  - Cuando se definen mas de un perfil, Spring Boot busca primero las propiedades en el archivo "application.properties" y 
  despues en los perfiles activos. Si una de las propiedades en los perfiles activos es similar a la de "application.properties" la sobrescribe.  
  **spring.profiles.active=dev,prod**: Esta caracteristica permite en el archivo "application.properties" definir cuales perfiles estan activos.  
  Si existe una misma propiedad en diferentes perfiles Spring Boot sobreescribe las anteriores y usa el valor del ultimo profile activo.  

  **@Profile("nameOfProfile")**: Permite definir para cual profile va estar disponible el Bean. Se definen en la clase de configuracion.  
   
====================================
# REST

**@GetMapping**: Identifica al EndPoint que va a responder ante una peticion de tipo GET.  GetMapping("/path"), se puede definir una url para 
acceder al EndPoint.  