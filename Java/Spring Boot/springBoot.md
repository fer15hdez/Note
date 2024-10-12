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

  - Se puede tener varios archivos de configuracion de tipo "application.yml" o de tipo "application.propeties".  
  - Configuracion de las dependencias principales
  dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web' // Basico para la web.
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa' // Para base de datos.  
    implementation 'org.springframework.boot:spring-boot-starter-validation' // Para  la validadcion de datos en la database.  
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    runtimeOnly 'org.postgresql:postgresql'

    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
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

- Toda la logica se debe hacer en las clases servicios y los controllers solo para ser la puerta de entrada de las resquest.  

====================================
# DATA BASE

**@Entity**: Define la clase como una entidad.  
**@Table(name = "T_PRODUCT")**: Permite definir un nombre para la tabla. Sino se define la anotacion el nombre que adopta
  es el nombre de la clase (ej. Product). El valor de la propiedad "ddl-auto: update" esta en la configuracion del proyecto
  creara una nueva tabla, si es create solo se sobre escribe.  
**@Id**: Define el campo como pk e identificador en la tabla. Es recomendable usar wrapper (envoltura, ej. Integer), si se usan tipos primitivos (ej. int) el valor inicial es cero
  e hibernate tratara buscar un elemento en la tabla con ese valor, sin embargo cuando apunta a null hibernate intenta insertar el nuevo valor.  
**@GeneratedValue**: Se autoincrementa el valor. Solo se debe usar en Primary Key. No permite el uso en pk compuestas.
  El valor por defecto es AUTO. Se puede definir una estrategia de generacion del id.    
**@Column(unique = true)**: Configura el campo como un valor unico dentro de la BD.  
Column(
            name = "c_name", // Define el nombre del campo en la DB. Sino se define se toma como valor el  nombre del campo.
            length = 20 // define el numero de caracteres que va a tener el campo
            updatable = false // Define si el valor se puede actualizar o no.  
    )

- Para hacer las consultas Se crea una interfaz que extiende de "JpaRepository<Product, Integer>". Para mejor organizacion el archivo debe nombrarse "NameEntityRepository".  
- Se le pasa a JpaRepository<Name_entity, data_type_pk>. (Nombre de la entidad y el tipo de datos de la llave primaria).  
- Para usar el recurso se crea una referencia de la interfaz "**private final ProductRepository productRepository;**".  
- Para insertar "**return productRepository.save(product);**"
- Delete: productRepository.deleteById(id). Con la notacion @DeleteMapping se define el controlador.  
- Para crear una consulta especifica (Ej. productRepository.findAllByNameContaining(name);), se el metodo en la clase Repository con el ?sufijo Containing?  

### Lombok dependecies (
  compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
)
**@Data**: Incluye las anotaciones @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.  
**@Setter**
**@Getter**
**@NoArgsConstructor**: Crea el constructor sin parametros.  
**@AllArgsConstructor**: Crea el constructor con todos los parametros.  
**@Builder**  Permite crear y diseannar objetos utilizando el patron de disenno Builder.  
- En las entidades es necesario crear un constructor vacio.  

**@ManyToMany**: Se define cual de las dos entidades va ser la duenna de la relacion y en esa entidad se ponen las anotaciones principales. 
  - Se crea un atributo de tipo lista en cada una de las entidades que apunta hacia la otra entidad, esto permite que sea bidireccional.
  - Estas configuraciones van en la tabla duenno:
      @JoinTable(
                name = "order_product",
                joinColumns = { @JoinColumn(name = "order_id")},/* Define la columna dentro de la tabla de union de la
                                                                    tabla duenna */
                inverseJoinColumns = { @JoinColumn(name = "product_id")} /* Define la columna de la otra tabla en la relacion
                                                                            en la tabla de union.*/
        )
**@ManyToOne**: En esta relacion siempre debe estar la notacion @JoinColumn para definir el campo
                que identifica la relacion.
                @JoinColumn(name = "category_id") Esta es la columna que se crea en la tabla
                para hacer refencia al campo "category".
  - Para que la relacion sea bidireccional debe tener:
      @OneToMany(mappedBy = "category", Indica que la relación es bidireccional
                                      y que el mapeo de la relación se encuentra en el campo "category" de
                                      la entidad Product.
            cascade = CascadeType.ALL, "Especifica que las operaciones de persistencia,
                                        actualización y eliminación realizadas en la entidad Autor
                                        se propagarán a las entidades relacionadas Libro"
      )
  - De la parte del MUCHOS debe tener una lista de la otra entidad. 
  - En la entidad de UNO debe tener un atributo que sea del tipo de la otra entidad
**@OneToOne**: @JoinColumn(name = "bar_code_id") // Esta columna se crea en la tabla para hacer referencia al campo 'barCode'.  
    - Para que la relacion sea bidireccionaal debe tener un campo en ambas tablas que identifique a la otra tabla.  
    @JoinColumn(name = "product_id") // Esta columna se crea en la tabla para hacer referencia al campo 'product'.  


### HERENCIA

**Clase Padre**
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // Esta propiedad esta en modo experimental
@MappedSuperclass // Identifica la clase como una superclase. Esta clase solo va a estar en el codigo,
                  // no se crea una tabla. Tampoco se puede insertar esta clase en la DB, ni se pueden hacer consultas.  

En la **clase hijas** solo se extiende de la clase padre y ponen las siguientes anotaciones:
  @EqualsAndHashCode(callSuper = true)
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @SuperBuilder // Esta propiedad esta en modo experimental
  @Entity                   

#### Estrategia de Herencia
**@Inheritance(strategy = InheritanceType.SINGLE_TABLE)**:  SINGLE_TABLE strategy crea una sola tabla con los atributos de
    las clases hijas y los de la clase padre. 
    - El nombre de la tabla es el de la clase padre.
    - La notacion se declara en la clase padre.  
    - En la tabla, en la base de datos, se crea un campo 'dtype' que identifica a que tabla pertenecen los datos insertados. 
    - Para cambiar el nombre del campo 'dtype' se usa la notacion @DiscriminatorValue("L"). Cuando se inserta una nueva fila 
      esta se identifica por la notacion @DiscriminatorValue("L") declarada en la clase hija, para saber a que clase pertenece la insercion.
    - Solo se puede hacer inserciones de los valores de cada clase (si es clase hija, los valores de la clase hija y de la clase padre, si es clase padre solo lo
      de la clase padre), los demas valores toman el valor null.  

**@Inheritance(strategy = InheritanceType.JOINED)**: Es recomendada para cuando existe un numero alto de subclases.  
- Esta estrategia declara la PK de la clase hija como llave foranea el id de la clase padre.
- Si se insertan datos para un entidad hija automaticamente se hacen dos insersiones, una en la clase con los campos correspondientes y una en la clase padre con los campos
  pertenecientes a la clase padre.  
- Para cambiar nombre de la llave foranea en la clase hija se usa la notacion @PrimaryKeyJoinColumn(name = "vehicle_id").  


# DTO Pattern
" Es una clase que te separa de manipular directamente las entidades, te permite devolver solo los datos que se necesiten para el cliente. No se devulven datos incesarios. Aumenta la seguridad.
Permite mayor flexibilidad. "
- Patron DTO (Crea una capa de abstraccion en el acceso a la entidad)
- Se pueden crear diferentes metodos con diferentes tipos de datos para exponer.
- La finalidad de este patron es exponer solo los datos que sean necesarios exponer.

- Al enviar los datos desde el formato de json para insertar una nueva entidad a traves de la clase DTO se deben usar los nombres de los campos de la clase DTO.  

- La clase public record ProductResponseDTO(
        Integer serial,
        String name,
        Double price,
        Integer stock
        ) {
}, 
  junto a los metodos toProductResponseDTO, los implementa el programador, permiten elegir cuales son los datos que se exponen una vez creado la entidad (ej. Producto)

====================================
# VALIDATION
- En las dependencias: "implementation 'org.springframework.boot:spring-boot-starter-validation' " // Para  la validadcion de datos en la database.  

**@Valid**: Esta anotacion indica que el valor debe ser validado. Utiliza las anotaciones de los campos del objeto a validar (ej. ProductRecordDto). 
@PostMapping("/db/dto")
    public Product createDtoProduct(@Valid @RequestBody ProductRecordDto productRecordDto){

        return this.productServiceBoualiali.createDtoProduct(productRecordDto); // Inserta el producto en la bd.
    }

**@NotEmpty(message = "This field must be filled")**: Permite validar el campo del objeto.      

====================================
# TESTING

- Recomendable en la carpeta de test crear una jerarquia de carpetas similar a la del proycto para poder encontrar con facilidad los test implementados y 
  a que clase se esta aplicando el test.  

- Hay que importar: "import org.junit.jupiter.api.*;" para usar los "assert".  
- Usando los assert se puede hacer las comparaciones de los paramatros que se quieren comprobar (ej. assertEquals(), assertNotNull(), etc)   

- Los Mock son objetos simulados a los objetos que imitan el comportamiento de objetos reales de una forma controlada.
- Con Mockito se puede hacer el uso de Mock para simular entidades y tambien se puede hacer uso para simular llamadas a metodos y comprobar
  si el comportamiento del codigo.  
