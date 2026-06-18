# GitHub Actions

## Los 4 pilares de GitHub Actions
  - Workflow (Flujo de trabajo): Es el proceso automatizado completo. Se guarda en un archivo de texto especial (formato YAML) dentro de tu repositorio, en la ruta .github/workflows/.
  - Event (Evento): El "disparador" o trigger. Es la acción que le dice a GitHub: "¡Oye, ejecuta el pipeline ahora!". Ejemplos: un push a la rama principal o cuando alguien abre un pull_request.
  - Job (Trabajo): Una sección dentro del flujo. Cada Job corre en una máquina virtual independiente (llamada Runner, que suele ser un Ubuntu en la nube de GitHub). Puedes tener un job para probar el código y otro para empaquetarlo.
  - Step (Paso): Las tareas individuales que se ejecutan secuencialmente dentro de un Job. Un paso puede ser un comando directo de terminal (como npm test o go test) o una Action (un script prehecho por la comunidad que puedes reutilizar, como uno para conectarte a Docker Hub o configurar un lenguaje). 

## Jobs
 - Los jobs corren en paralelos.   
   - GitHub Actions los ejecutará al mismo tiempo en máquinas virtuales totalmente diferentes y aisladas.  
   - Al correr en máquinas diferentes, el Job B no tiene acceso a los archivos que descargó o generó el Job A. Si el Job A hizo un actions/checkout, el Job B tendrá que hacer su propio actions/checkout si necesita leer el código.
   - Si se necesita que alguno sea secuencial a otro se le debe especificar.    
     - `needs`: 