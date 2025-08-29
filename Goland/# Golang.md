# Golang 

## Comandos
 ` go list -f '{{.Target}}' `
  `go clean -modcache`: Limpia la cache de los modulos   


## Crear un modulo
`go mod init nombre_modulo`
- Esto crea un archivo "go.mod"  
- Para usar un modulo se importa desde el archivo donde se necesita
    ````go
    import (
	"fmt"
	"example.com/greetings"
    )
    ```
- Para especificar la direccion del modulo que se quiere utilizar cuando es local    
    `go mod edit -replace nombre_mod_actual=dir/nombre_mod_utilizar`  
    - Esto escribe en el archivo "go.mod"  
    `replace example.com/greetings => ../greetings`  

- Para sincronizar las dependencias de los modulos  
    `go mod tidy`
## Crear workSpace
 `go work init ./hello ./greetings` -> Crear un archivo "go.work" donde se adiciona los valores:
   ```go
   go 1.24.4

    use (
        ./hello
        ./greetings
    )
   ``` 
   - Esto le dice a cualquier llamada que use ?¿?¿?¿?¿?


## Escribir en la consola
- Printf(): Muesta el texto formateado.  
    `fmt.Printf("i has value: %v and type: %T\n", i, i)`
- Println(): Muestra el texto e imprime un salto de linea.  
- Print(): Muestra el texto tal y como se escribe.       

## Logger
```go
    import (
	"log"
    )

    log.Fatalf("Error al obtener el directorio actual: %v", err)
```
## Variables
 `var i int` -> Declara una variable de tipo entero.  
 `var c, python, java bool` -> Declara varias variables del mismo tipo.  
 `k := 3` -> Forma corta de declaracion. Identifica el tipo del valor asignado.  

 - Sin inicializar
     - 0 para tipos numéricos,
     - false para tipo booleano, y
     - "" (la cadena vacía) para cadenas de texto.

### Tipos
 - bool, string, 
 - int(enteros especificos: int8  int16  int32  int64),  
     uint uint8 uint16 uint32 uint64 uintptr // Son los positivos de los int  
     byte // alias para uint8  
     rune // alias para int32
          // representa un punto de código Unicode
 - float32, float64
 - complex64 complex128         

 - Convertir int a String:
    `import "strconv"`
    `texto + strconv.Itoa(numero)`  
 - Convertir int a float64: `float64(numero_int)`  

### Constantes
 - Las constantes se declaran como variables, pero con la palabra clave `const`  
 - Las constantes no se pueden declarar usando la sintaxis `:=`  

## Control de Flujo

 ### IF y ELSE
    ```go
    // v tiene alcance hasta el else
    // el puede tener una expresion a evaluar antes del ";"
        if v := math.Pow(x, n); v < lim {
            return v
        } else {
            fmt.Printf("%g >= %g\n", v, lim)
        }
    ```
 ### For
    ```go
    for indice, valor := range coleccion {
		fmt.Printf("Accion")
	}
    for i := 0; i < 10; i++ {
		sum += i
	}
    // for continuo
    for ; sum < 1000; {
		sum += sum
	}
    // for como while
    for sum < 1000 {
		sum += sum
	}
    // for infinito
    for {
	}


    ```    

 ### Switch
   ```go
   // Se evalua de arriba hacia abajo, si da un verdadero termina
   // Puede sin la condicion inicial (os := runtime.GOOS; os) y seria true. Es util para sustituir una larga 
   // lista de if else
    switch os := runtime.GOOS; os {
        case "darwin":
            fmt.Println("OS X.")
        case "linux":
            fmt.Println("Linux.")
        case valor >= 5 && valor <= 10: // Se pueden hacer comparaciones en el mismo case
            fmt.Println("Mi texto.")
        case "Linux", "Mac OS", "Otro OS": // Si hay varios valores con la misma logica se pueden agrupar en el case
            fmt.Println("Unix.")    
        default:
            // freebsd, openbsd,
            // plan9, windows...
            fmt.Printf("%s.\n", os)
        }
   ```

## Punteros
- Un puntero contiene la dirección de memoria de un valor. 
  `var p int = 10` : p es una variable que tiene como valor en memoria 10.   
  `var p *int` : p es un puntero a un valor int.  
  `p = &i`: p es un puntero a i. (p tiene la dir de memoria al valor de i).  
  `*p = 21`: el * desreferencia a p y modifica el valor que esta en memoria.  

## Function
- Sintaxis
    ```go
    
    func FunctionName(param1 type, param2 type, param3 type) type {
        // code to be executed
        return output
    }
    ```
    ```go

    package main
    import ("fmt")

    // Se pueden devolver uno o mas de un valor(ej. result y text1)
    // Se puede 
    func myFunction(x int, y string) (result int, txt1 string) {
    result = x + x
    txt1 = y + " World!"
    return
    }
    ```
### Defer
   - Una instrucción defer, aplaza la ejecución de una función hasta el retorno de la funcion circundante (que la contiene).  
        La funcion defer se ejecuta cuando la funcion donde esta termina.  
   - Los argumentos de la llamada diferida se evalúan inmediatamente, pero la llamada a la función no se ejecuta hasta que la función que la rodea retorna.  
   - Si existen mas de una funcion defer estas se almacenan en una pila LIFO y esta se ejecuta cuando termina la funcion donde estan.  
### Funcion clausuras o closures
   - Una función también puede construir y devolver otra función.
    
    ```go
    package main

    import "fmt"

    // crearIncrementador es una función que retorna OTRA función.
    // La función retornada "recuerda" el valor de 'cantidad' (closure).
    func crearIncrementador(cantidad int) func(int) int {
        // Esta es la función anónima que será retornada
        return func(x int) int {
            return x + cantidad
        }
    }

    func main() {
        // Creamos un incrementador que suma 5
        incrementarPorCinco := crearIncrementador(5)

        // Creamos un incrementador que suma 10
        incrementarPorDiez := crearIncrementador(10)

        fmt.Println("5 + 3 =", incrementarPorCinco(3))   // Salida: 5 + 3 = 8
        fmt.Println("10 + 7 =", incrementarPorDiez(7)) // Salida: 10 + 7 = 17
    }
      
    ```

## Collections

### Arrays
- Los arrays no se pueden redimensionar  
  `var a [10]int`: declara una variable a como un array de diez enteros.  


### Slice
- Un slice se forma especificando dos índices, un límite inferior y superior, separados por dos puntos.  
- Un slice no almacena ningún dato, solo describe una sección de un array subyacente (array real (o físico)).  
  Es una especie de puntero.  
- Cambiar los elementos de un slice modifica los correspondientes elementos de su array subyacente.  
- Otros slices que comparten el mismo array subyacente verán esos cambios.  
- Un slice no se puede modificar mas alla de la capacidad del array subyacente (array real (o físico)).  
- El valor cero de un slice es nil.  
- Un slice nulo tiene una longitud y capacidad de 0 y no tiene array subyacente.  
- Los slices pueden contener cualquier tipo, incluyendo otros slices.  
    `s := make([][]int, dy)`: un slice de slice de enteros.  

- Syntax  
  `slice_name := []datatype{values}`  
  `myslice := []int{}` Un slice vacio.  
  `myslice := []int{1,2,3}`  

- Capacidad y len()
  - len() function - returns the length (longitud) of the slice (the number of elements in the slice)
  - cap() function - La capacidad de un slice es el número de elementos en el array subyacente (array real (o físico)), contando desde el primer elemento en el slice.  

- Funcion Make()  
    - If the capacity parameter is not defined, it will be equal to length.  
      `slice_name := make([]type, length, capacity)` 

- Agregar elementos al slice  
    `s = append(nombre_slice_a_modificar, elem, elem2, ...)` 
    - Los elementos a agregar deben ser del mismo tipo que los contenidos por el slice.  

### Struct
- Los campos de struct se pueden acceder a través de un puntero a un struct.  
    `p := &v`
	`p.X = valor`
    `fmt.Println(p.X)`

- Sintaxis
    ```go
    type struct_name struct {
        member1 datatype;
        member2 datatype;
        member3 datatype;
    }
    // ej
    type Persona struct{
        name string
        age int
    }

    // Acceso a un struct
    var person1 Persona // crea la struct
    // Asignara valores
    person1.name = "Maria"
    person1.age = 30

    // Acceder a los valores de los campos 
    fmt.Print(person1.name)
    ```      
### Maps
- El valor cero de un map es nil. Un map nulo no tiene claves, ni se pueden agregar claves.  
- La funcion make retorna un map del tipo dado, inicilizado y listo para usar.  
- Sintaxis
    ```go
    var a = map[KeyType]ValueType{key1:value1, key2:value2,...}
    b := map[KeyType]ValueType{key1:value1, key2:value2,...}

    // ej
    var a = map[string]string{"brand": "Ford", "model": "Mustang", "year": "1964"}
    b := map[string]int{"Oslo": 1, "Bergen": 2, "Trondheim": 3, "Stavanger": 4}

    // Con make() function
    var a = make(map[KeyType]ValueType)
    b := make(map[KeyType]ValueType)
    ```   
- Eliminar elementos de un map
  `delete(map_name, key)`      

- Iterar sobre el maps
```go
    func main() {
        a := map[string]int{"one": 1, "two": 2, "three": 3, "four": 4}

        for k, v := range a {
            fmt.Printf("%v : %v, ", k, v)
        }
    }
```

- Comprobar que una clave este presente
  `elem, ok = m[key]`: Si key está en m, entonces ok es true y `elem` toma el valor. Si no esta `elem` es cero y `ok` es false.  

## Método
- Un método es esencialmente una función, pero con una diferencia crucial: tiene un argumento receptor especial.  
- Un método es una funcion asociada a cualquier tipo definido por el usuario (estructuras, tipos básicos con alias, etc.).   
- Si el tipo receptor es un puntero (*TipoReceptor), el método puede modificar el valor original del receptor.   
- Solo puedes declarar un método con un receptor cuyo tipo este definido en el mismo paquete como el método (debe estar en el mismo archivo).  

- Sintaxys
```go
    func (nombre_receptor TipoReceptor) NombreMetodo(parametros) (retornos) {
        // Cuerpo del método
    }
```

## Interfaces
- Sintaxy
```go
    type NombreDeLaInterfaz interface {
        // Firma del método 1: nombre(parametros) (retornos)
        Metodo1(int) string
        // Firma del método 2:
        Metodo2() error
        // ... más firmas de métodos
    }
```
```go
    type Abser interface {
       Abs() float64
    }
    type MyFloat float64
    type Vertex struct {
    X, Y float64
    }

    func (v *Vertex) Abs() float64 { // Receptor por PUNTERO
    return valor
    }

    func (v Vertex) Metodo_Valor() float64 { // Receptor por VALOR
    return valor
    }

    func (f MyFloat) Abs() float64 {
        return valor
    }

    // Cuando defines un método con un receptor por puntero (func (v *Vertex) Abs() float64), 
    // ese método solo puede ser llamado directamente en un puntero a Vertex.

    var a Abser
    f := MyFloat(10)
    v := Vertex{1, 2}
    a = f // Se usa por valor
    a = v // Da error, porque trata de asignar a la interfaz Abser (que es "a") Vertex que implementa la interfaz por puntero.   
```
- Un tipo implementa una interfaz implementando sus métodos. No hay una declaración explícita de intenciones, ni la palabra clave "implements".  
   - Solo se imprementa los mentodos de la interfaz, no existe una palabra clave para identificarlo, con eso es suficiente para implementar la interfaz.  
- Para usar el polimorfismo si se declara de tipo puntero la implementacion de una interfaz **(func (v *Vertex) Abs() float64)** 
  esta no se puede usar en un TYPE declarado de tipo valor.   
  (Las interfaces cuando se implementan usando un receptor por VALOR se pueden usar usando TYPE por VALOR y por PUNTERO. Si la interface se implementa por PUNTERO solo se puede usar por el TYPE por puntero)(Esto suscede cuando tratamos de usar el polimorfismo usando la implementacion de una interfaz).   
- Si al menos UNO DE LOS METODOS de un struct usa un receptor por puntero, para que ese struct implemente la interfaz, siempre debe pasar un puntero de ese struct. Es decir, cuando se vaya a pasar ese `struct` como parametro donde se pase la `interfaz` (como parametro) que implementa se debe pasar un puntero del `struct`.    

### Valores de interfaz
- Una variable de interfaz en Go se representa internamente como una dupla (par de valores).  
  ```go
        var i interface{} // Declaramos una variable de interfaz vacía

	// En este punto, 'i' es un valor de interfaz nulo.
	// Su tipo concreto es <nil> y su valor concreto es <nil>.
	fmt.Printf("Valor de i: %v, Tipo de i: %T\n", i, i) // Salida: Valor de i: <nil>, Tipo de i: <nil>

    a := i 
    // "a" es de tipo "i" (la interfaz) y valor <nil>  

  ```

### Valores de interfaz nulo
```go
    package main

    import "fmt"

    // Definimos una interfaz simple
    type Saludar interface {
        Hola() string
    }

    // Definimos un tipo que implementa la interfaz
    type Persona struct {
        Nombre string
    }

    func (p Persona) Hola() string {
        return "Hola, mi nombre es " + p.Nombre
    }

    func main() {
        var s Saludar // Declaramos una variable de interfaz de tipo 'Saludar'

        // En este punto, 's' es nula (tipo=<nil>, valor=<nil>)
        fmt.Printf("Valor de s: %v, Tipo de s: %T\n", s, s) // Salida: Valor de s: <nil>, Tipo de s: <nil>

        if s == nil {
            fmt.Println("La interfaz 's' es nula. No tiene tipo ni valor.")
        }

        // ¡PELIGRO! Intentamos llamar a un método en una interfaz nula.
        // Esto causará un panic en tiempo de ejecución.
        fmt.Println(s.Hola()) // Esto va a fallar: panic: runtime error: invalid memory address or nil pointer dereference
    }
```

### La interfaz vacía
- El tipo de interfaz que específica cero métodos es conocida como una _interfaz_vacia: `interface{}`
- Un tipo implementa una interfaz si cumple con todos los métodos de esa interfaz. Si una interfaz no requiere ningún método, entonces todos los tipos (números enteros, cadenas de texto, structs, slices, mapas, etc.) automáticamente cumplen ese "contrato" vacío.  
- Debido a que puede contener cualquier tipo de valor, interface{} es la forma de Go de manejar valores de tipo desconocido o arbitrario. Es el equivalente más cercano al concepto de "Object" en Java o "Any" en TypeScript/Python, aunque con la seguridad de tipos de Go.  

## GoRoutine
 - Las goroutine son funciones que se ejecutan de forma independiente y concurrente

## Canales
 - Es cómo las goroutines se comunican entre sí de forma segura.
 - WaitGroups se usan cuando solo necesitas esperar a que un grupo de goroutines termine. 
    Es un contador que garantiza que el programa principal no se cierre prematuramente.
- Cuando creas un canal con make(chan int), este es un canal bidireccional por defecto, lo que significa que puedes enviar y recibir valores de él. 
    + Es en la firma (argumentos) de la función donde le dices a Go si debe ser de solo escritura (chan<-) o de solo lectura (<-chan).
- Canal de solo lectura: `<- chan int`. 
    + Se define en el parametro de la funcion(ej. `func calculateSum(numbers []int, result <- chan int, wg *sync.WaitGroup) {}`)  
- Canal de solo escritura: `chan <- int`  
    + Se define en el parametro de la funcion(ej. `func calculateSum(numbers []int, result chan<- int, wg *sync.WaitGroup) {}`)
- Si desde un goroutine (funcion) se envian varios datos por un canal se debe esperar en el otro goroutine con el que se comunica (ej. main()) todos los datos que se enviaron.     



## Trabajo con archivos
```go

    import(
        "os"
        "path/filepath"
    )

    // Path actual
    os.Getwd()

    // Listar archivos y dir de un path
    // Retorna una slice de fs.DirEntry y un error.
    // Cuando se recorre el slice se puede preguntar si es un dir o file(entry.IsDir())
    os.ReadDir(dirname string)

    // Obtener el ultimo elemento de la ruta 
    // Si termina el 
    filepath.Base()
    
    // Obtener la Extensión de un archivo
    // En archivos ".bashrc" devuelve una cadena vacia
    // En archivos "readme" (sin una extencion con punto) devuelve una cadena vacia
    // "archivo.tar.gz" devuelve ".gz"
    filepath.Ext(path string)
```

- Crear un directorio: `os.Mkdir("nombre_dir", 0755)`
- Crear directorios anidados: `os.MkdirAll("dir1/dir2/dir3", 0755)`
- Eliminar directorio (vacío): `os.Remove("nombre_dir")`
- Eliminar directorio (y su contenido recursivamente): `os.RemoveAll("nombre_dir")`

```go 
    // informacion de un archivo
    fileInfo, err := os.Stat("mi_archivo.txt") // Asume que 'mi_archivo.txt' existe

    fmt.Println("Nombre del archivo:", fileInfo.Name())
	fmt.Println("Tamaño (bytes):", fileInfo.Size())
	fmt.Println("Es directorio:", fileInfo.IsDir())
	fmt.Println("Permisos:", fileInfo.Mode())
	fmt.Println("Última modificación:", fileInfo.ModTime())
```
- Eliminar Archivos: `os.Remove`
- Renombrar y Mover Archivos: `err = os.Rename("viejo_nombre.txt", "nuevo_nombre.txt")`
- Mover: `err = os.Rename("nuevo_nombre.txt", "temp_dir/archivo_movido.txt")`. El dir temp_dir debe existir.  
- Leer de un Archivo
    - Leer un archivo completo: `content, err := os.ReadFile("datos.txt")`
    - Leer por bloques: 
        ```go
            buffer := make([]byte, 10) // Buffer para leer 10 bytes a la vez
            for {
                n, err := file.Read(buffer) // Lee hasta 10 bytes en el buffer
                if err != nil {
                    if err.Error() == "EOF" { // EOF (End Of File) significa que llegamos al final
                        break
                    }
                    fmt.Println("Error al leer:", err)
                    return
                }
                fmt.Printf("Leídos %d bytes: %s\n", n, string(buffer[:n])) // buffer[:n] para imprimir solo los bytes leídos
            }
        ```
- Escribir en un Archivo: 
    ```go
        file, err := os.Create("datos.txt")
        // Escribir un string
	    bytesWritten, err := file.WriteString("¡Hola, Go!\n")
        // Escribir bytes
        data := []byte("Más datos en bytes.\n")
        bytesWritten, err = file.Write(data)

    ```     
- Crear un Archivo: 
    ```go
        // os.Create crea un archivo o lo trunca si ya existe.
        // Retorna un puntero a os.File y un error.
        file, err := os.Create("mi_archivo.txt")
    ```       

## Trabajo en consola
```go
    import (
	"bufio"
	"fmt"
	"os"
	"strconv" // Para convertir strings a otros tipos
	"strings" // Para limpiar espacios y saltos de línea
)

    // Crear un nuevo lector para la entrada estándar (teclado)
	reader := bufio.NewReader(os.Stdin)

    nombre, err := reader.ReadString('\n') // Leer hasta el salto de línea

    // Eliminar el salto de línea al final del string, que ReadString incluye
	nombre = strings.TrimSpace(nombre) // TrimSpace elimina espacios y saltos de línea (incluyendo \r\n de Windows)

```
## Errores
 - Verificación de errores: Usar el patrón `if err != nil`.  
 
 ```go
    func openFile(path string) error { // devolver el error para el use la funcion tenga como manejarlo
        archivo, err := os.Open(path) //capturar el error

        if err != nil { // patron para manejar el error
            log.Printf("\nError al abrir archivo en funcion openFile: %v", err.Error()) // Escribir el error especificando funcion y el error real
        } else {
            fmt.Printf("Archivo: %v", archivo)
        }

        return err // Retornar el error
  }
 ```