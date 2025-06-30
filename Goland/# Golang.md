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
- Para especificar la direccion del modulo que se quiere utilizar   
    `go mod edit -replace nombre_mod_actual=dir/nombre_mod_utilizar`  
    - Esto escribe en el archivo "go.mod"  
    `replace example.com/greetings => ../greetings`  

- Para sincronizar las dependencias de los modulos  
    `go mod tidy`