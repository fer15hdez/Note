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
   - `Job Outputs (Salidas de Trabajo)` permiten transferir datos entre jobs. Permiten definir variables en el Job 1 que GitHub Actions mantendrá en memoria y pondrá a disposición del Job 2.  


## Registry

### Docker hub
  - El login se hace usando la accion `docker/login-action@v3`.  
  - Se deben crear los secrets de usuario y pass en github para usarlos en el login. `username: ${{ secrets.TOKEN_USERNAME_DOCKERHUB }}`, `password: ${{ secrets.TOKEN_WORKFLOW_DOCKERHUB }}`
  - Para subir la imagen a docker hub se usa la action `docker/build-push-action@v6`.  

### Docker Hub a GHCR (GitHub Container Registry)
  - En GHCR GitHub Actions genera automáticamente un token de seguridad temporal y único para cada ejecución del pipeline llamado ${{ secrets.GITHUB_TOKEN }}.  
  - Las imagenes se guardan en el registry de github.  
  - Se debe especificar el registry (url): `ghcr.io`.  
  - Todo el nombre del repositorio debe estar en minúsculas (GitHub es estricto con esto): `ghcr.io/nombre_de_usuario_en_github/nombre_de_la_imagen:tag`.  
  -  Cada vez que un workflow arranca, GitHub crea un secreto dinámico en memoria llamado `secrets.GITHUB_TOKEN`. Sin embargo, por seguridad, este token a veces viene en modo "solo lectura". Para que tu pipeline pueda subir una imagen, debes darle explícitamente permisos de escritura en el YAML usando la propiedad `permissions`.  
  - Si se sube una imagen para el registry de github desde un repositorio y se trata de subir otra imagen con el mismo nombre desde otro repositorio no lo permite. Para permitir hay que ir a los Packages y entrar a la imagen y cambiar los permisos de los repositorios que pueden escribir sobre la imagen. (Raiz github/Packages/nombre-imagen/Packages setting/Add Repository).   
