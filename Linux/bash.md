# Bash

##
`set -euo pipefail`

## Variable
### Declarar una variable
- `nombre_variable`=[valor]
- Si no se pone el valor es una varible vacia. Para que sea variable debe tener el signo de `=`.  
- El signo de igual no debe tener espacios antes o despues.

### Mostrar la variable
- se antepone el signo de `$`. Ej. `$nombre-var`

### Expansión de variable 
- `${var:-defecto}`: No modifica la variable, solo muestra el valor 'defecto' si no esta definida o esta vacia.

## Ciclos
### FOR
#### Iteración sobre una lista o elementos:
    ```bash
    for variable in elemento1 elemento2 elemento3; do
        # Comandos a ejecutar
        echo "$variable"
    done

    # Ej. Procesar todos los archivos con una extensión específica.
    for archivo in *.txt; do
        echo "Procesando: $archivo"
    done
    ```

    ```bash
    # Iterar sobre arrays:
    frutas=("manzana" "pera" "plátano")
    for fruta in "${frutas[@]}"; do
        echo "Me gusta la $fruta"
    done
    ```
#### Est estilo C (para contadores numéricos):
    ```bash
    for (( inicializacion; condicion; incremento )); do
        # Comandos a ejecutar
    done

    # Ej. Ejecutar una tarea un número determinado de veces.
    for i in {1..5}; do
        echo "Número: $i"
    done
    ```

### Bucle while read    
- El bucle while combinado con el comando read es la herramienta estándar y más segura en Bash para leer archivos o flujos de datos línea por línea.

#### Sintaxis
    ```bash
    while IFS= read -r linea; do
        # Comandos que utilizan la variable $linea
        echo "$linea"
    done < archivo.txt

    # El comando read en Bash (Linux) es una utilidad integrada que se utiliza para leer una línea de texto desde la entrada estándar (teclado, un archivo o una tubería) y asignarla a una o varias variables.

    # IFS= (Internal Field Separator vacío): Evita que Bash elimine los espacios en blanco iniciales y finales de cada línea.
    # -r: Evita que el comando read interprete las barras invertidas (\) como caracteres de escape (muy útil al leer rutas de archivos).
    # < archivo.txt: Redirige el contenido del archivo hacia la entrada del bucle.
    ```
    ```bash
    # Ej. Procesar archivos de texto o logs línea por línea:
    while IFS= read -r linea; do
        if [[ "$linea" == *"ERROR"* ]]; then
            echo "Alerta encontrada: $linea"
        fi
    done < /var/log/sistema.log

    # Ej. Leer la salida de un comando línea por línea (mediante tuberías / pipes):
    netstat -tuln | while IFS= read -r linea; do
        echo "Conexión activa: $linea"
    done
    ```