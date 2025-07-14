# Golang 

## Comandos
 ` go list -f '{{.Target}}' `


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

## Escribir en la consola
- Printf(): Muesta el texto formateado.  
    `fmt.Printf("i has value: %v and type: %T\n", i, i)`
- Println(): Muestra el texto e imprime un salto de linea.  
- Print(): Muestra el texto tal y como se escribe.       

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
#### Defer
    - Una instrucción defer, aplaza la ejecución de una función hasta el retorno de la funcion circundante (que la contiene).  
    La funcion defer se ejecuta cuando la funcion donde esta termina.  
    - Los argumentos de la llamada diferida se evalúan inmediatamente, pero la llamada a la función no se ejecuta hasta que la función que la rodea retorna.  
    - Si existen mas de una funcion defer estas se almacenan en una pila FIFO y esta se ejecuta cuando termina la funcion donde estan.  

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
  `elem, ok = m[key]`: Si key está en m, entonces ok es true.  

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
    type Vertex struct {
    X, Y float64
    }

    func (v *Vertex) Abs() float64 { // Receptor por PUNTERO
    return valor
    }

    func (v Vertex) Metodo_Valor() float64 { // Receptor por VALOR
    return valor
    }

    // Cuando defines un método con un receptor por puntero (func (v *Vertex) Abs() float64), 
    // ese método solo puede ser llamado directamente en un puntero a Vertex.
```
- Un tipo implementa una interfaz implementando sus métodos. No hay una declaración explícita de intenciones, ni la palabra clave "implements".  
   - Solo se imprementa los mentodos de la interfaz, no existe una palabra clave para identificarlo, con eso es suficiente para implementar la interfaz.  
