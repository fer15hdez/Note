To start the project is used the command "docker-compose" in the v2 is "docker compose"

# Manage imges
<code>docker image --help</code>: show all the command available.  
```build:``` to build the image from a ***dockerfile***  
```history```: show the history of a image, how was build.  
```inspect```: detail and inside of a image. ```sudo docker image inspect IMAGE ID```  
```docker image ls```: show all the download images.  
```docker image ls -a```: muestra imágenes intermedias.  
```-q```: para ver los números de identificación.  
```prune```:  borrar todas las imágenes que no estés utilizando.  

#### Descargar una imagen de un repositorio
```pull```: download images from a repository. Ex: ```docker image pull ubuntu```.  
```docker image pull ubuntu:xenial```: a specific version.  
```docker pull nameUser/nameImage```: son imagenes de usuarios.  
```push```: upload a image to a repository.  

```docker rmi <nombre de la imagen>```: to remove image.    
```rm```:  to remove container.  

### Comandos básicos con imágenes  
```ls```: para saber las imágenes que tienes en tu equipo.  

***

# Manage Container
```docker container --help```  
```docker run atareao/hola```: start a container.  
```docker ps```: show all the container.  
```docker container ls```: show all the container.  
```docker ps -a```: show all the container, even stoped.  

### Naming Container
```docker run -d --name myContainer atareao/hola``` : Create a container.    
Si intentas llamar a dos contenedores por el mismo nombre, como te puedes imaginar, se producirá un error, y no iniciará el segundo contenedor.  

```docker container rename ID newName```: rename a container.  
*sleep 100* : stay the container runing. Puting in end of line. Ex: *docker run atareao/hola sleep 5*  
*-e*: allows passing environment variables.  
*--rm*: delete the container when it is stoped.

### Start, stop and pause
```docker start IDcontainer```:  
```docker stop IDcontainer```:  
```docker restart 1e0e92b8255e```:  
```docker pause 1e0e92b8255e```:  
```docker unpause 1e0e92b8255e```:  

*-d* : ejecuta el container en 2do plano.  

### Copying between host and container
*docker cp archivo.txt midocker:/toDir*  
*docker cp midocker:archivo2.txt /toDirInHost*

### Exponiendo puertos
*docker run -d --name test01 -p 81:80 nginx:alpine*: option ***-p*** when [host port]:[contianer posrt]

### Exponiendo volúmenes
*-v*: ex. docker run -d -p  80:80 -p 443:443 -v "$(pwd)"/dir/host:/dir/of/docker 
--name nameContainer atareao/imageDocker

### Inside to container
*docker exec -it midocker bash*: permite trabajar desde la terminal en el container.  
```exit```: salir del container.  

### Delete container
*docker rm midocker:* Delete one by one.  
*docker container prune*: Delete all the stopped container . 

## Run Specific image
### PostgreSQL
*docker run -d --name postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 postgres*

***

# Dockerfile
1. ***ADD*** copia un archivo del host al contenedor.  
1. ***CMD*** el agumento que pasas por defecto.  
1. ***ENTRYPOINT*** el comando que se ejecuta por defecto al arrancar el contenedor.  
1. ***ENV*** permite declarar una variable de entorno en el contenedor.  
1. ***EXPOSE*** abre un puerto del contenedor.  
1. ***FROM*** indica la imagen base que utilizarás para construir tu imagen personalizada. Esta opción es obligatoria, y además debe ser la primera instrucción del ***Dockerfile***.  
1. ***MAINTAINER*** es una valor opcional que te permite indicar quien es el que se encarga de mantener el ***Dockerfile***.  
1. ***ONBUILD*** te permite indicar un comando que se ejecutará cuando tu imagen sea utilizada para crear otra imagen.  
1. ***RUN*** ejecuta un comando y guarda el resultado como una nueva capa.  
1. ***USER*** define el usuario por defecto del contenedor.  
1. ***VOLUME*** crea un volumen que es compartido por los diferentes contenedores o con el *host*.  
1. ***WORKDIR*** define el directorio de trabajo para el contenedor.  
