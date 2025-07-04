# Golang 

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

## Collections
### Slice
- Syntax  
  `slice_name := []datatype{values}`  
  `myslice := []int{}` Un slice vacio.  
  `myslice := []int{1,2,3}`

- Capacidad y len()
  - len() function - returns the length of the slice (the number of elements in the slice)
  - cap() function - returns the capacity of the slice (the number of elements the slice can grow or shrink to)

- Funcion Make()  
    - If the capacity parameter is not defined, it will be equal to length.  
      `slice_name := make([]type, length, capacity)`   
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