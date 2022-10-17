import re
"""
".cumplir" -> "Debe tener UN caracter cualquiera antes del punto y cumplir los restantes caracteres
                despues del punto"
"\" -> "Permite escapar para comprobar un caracter especial"   
[0-9] -> Rangos. Todos los digitos de 0 hasta 9.
[0-9a-zA-Z] -> Rangos. Todos los digitos de 0 hasta 9, las letras desde 'a' hasta 'z' minusculas,
                las letras de 'A' hasta la 'Z'.
Dentro de las clases de caracteres los caracteres especiales no necesitan ser escapados.  

 "^" -> todo lo que aparece a la derecha.  
 
 “\d”:  un dígito. Equivale a [0-9]
 “\D”:  cualquier carácter que no sea un dígito. Equivale a [^0-9]
 “\w”: cualquier caracter alfanumérico. Equivale a [a-zA-Z0-9_]
 “\W”: cualquier carácter no alfanumérico. Equivale a [^a-zA-Z0-9_]
 “\s”: cualquier carácter en blanco. Equivale a [ \t\n\r\f\v]
 “\S”: cualquier carácter que no sea un espacio en blanco. Equivale a [^ \t\n\r\f\v]
 
 ------REPETICIONES------
 - El carácter '+' indica que lo que tenemos a la izquierda, sea un carácter como 'a', una clase como '[abc]'
   o un subpatrón como (abc),puede encontrarse una o mas veces.
 - El carácter '*', lo que se sitúa a su izquierda puede encontrarse cero o mas veces.
 - El carácter '?' indica opcionalidad, lo que tenemos a la izquierda puede o no aparecer 
   (puede aparecer 0 o 1 veces).
 - Llaves '{}'sirven para indicar el número de veces exacto que puede aparecer el carácter de la izquierda, o bien un 
   rango de veces que puede aparecer.
   {3} indicaría que tiene que aparecer exactamente 3 veces.
   {3,8} indicaría que tiene que aparecer de 3 a 8 veces.
   {,8} de 0 a 8 veces y {3,} tres veces o mas (las que sean).


         

"""
if re.match("expresion regular (ER)", "cadena a evaluar"):
    print “cierto”

re.match("python|jython|cython", "python") "is true" "Opciones en la ER"
re.match("(p|j|c)ython", "python") "is true" "Opciones en la ER, son llmados grupos '()'"
re.match("[pjc]ython", "python") "is true" "Opciones en la ER, son llmados clase de caracteres"
re.match("python[.,]", "python.") "is true"
re.match("python[^0-9a-z]", "python+") "is true" "no puede terminar ni en numero ni en letra minuscula"


