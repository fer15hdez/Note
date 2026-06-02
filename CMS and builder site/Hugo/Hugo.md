# HUGO

## version 0.145.0
- `hugo new site nombre-sitio`: Crea una estructura de carpetas del entorno de hugo.  
- `hugo new content <SECTIONNAME>/<FILENAME>.<FORMAT>`: Crea un archivo en la carpeta content dentro la carpeta SECTIONNAME (Ej. post/docum.md).  
- `hugo`: Crea toda la estructura de archivos del sitio web en la carpeta public. Para visualizar el sitio se debe correr en un servidor web.  

`CMD ["hugo", "server", "--bind", "0.0.0.0", "--appendPort=false", "--disableFastRender"]`: Comando en dockerfile para iniciar el server cuando se inicie un contenedor.   
- Corre normalmente en el puerto 1313.  