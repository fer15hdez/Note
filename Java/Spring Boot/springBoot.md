# Structure of project
Controler: Is the layer(capa) of presentation. In this layer is where are the endpoint.    
Service: Is the layer of business logic.  
Domain (Dominio): Is this the layer where we place the POJO classes, meaning this is where our domain resides.  
Test: The place where the tests are. 

====================================
# Banner
Se crea un archivo banner.txt en la carpeta resources


====================================
# Configuration

**@Configuration** : Con esta anotacion en una clase le indica a Spring Boot que esta clase se usa para definir configuraciones.  


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

## Bean
Los **Bean** son los metodos que tienen un decorador de spring (ej. @service, @RestController, etc).  
**@Bean("nameOfBean")**: Permite agragar un nombre al Bean y con la anotacion @Qualifier("nameOfBean") llamar al Bean deseado.  
- Es la forma que utiliza Spring Boot para denotar los componentes y asi poder utilizarlo en la inyeccion de dependencia.  
- La inyeccion de dependencia de spring boot es sinonimo de la dependiencia entre clases, pero para desaclopar el codigo y que se encargue Spring Boot
se usan los Bean.  
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

**@RestController**: Le dice a spring que debe tomar esta clase como un contralador.  
**@ResponseStatus(HttpStatus.ACCEPTED)**: Si se ejecuta sin excepciones devuelve el http method 'ACCEPTED'.  
**@GetMapping**: Identifica al EndPoint que va a responder ante una peticion de tipo GET.  GetMapping("/path"), se puede definir una url para 
acceder al EndPoint.  

- Los getter and setter son necesarios para la serialitation y el proceso inverso. Permiten el acceso a los campos privados de las clases.  

**@PathVariable**: Permite pasar un valor por la url. El valor de la url debe ser igual que el nombre del parametro.  
@GetMapping({"/hello/{name}", "/hola/{name}"})
public String greeting(@PathVariable String name){}  
**@RequestParam("user-name")**:  Permite especificar el valor que se pasa por parametro en la url. 
http://localhost:8080/sistema/api/v1/clientes/param?user-name=fernan&last-name=vel