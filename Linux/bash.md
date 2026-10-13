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