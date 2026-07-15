---
title: "Linux"
subtitle: ""
date: 2026-06-04T15:58:26+03:00
lastmod: 2026-06-04T15:58:26+08:00
draft: false

series: ["S.O"]
tags: [S.O, Linux]
categories: [S.O]
weight: 2  # Esto le dice a Hugo que es el capítulo 1
---


# Install
*sudo apt-get install [program]*
*--no-install-recommends*: solo instala los paquetes nombrados.   
*rm -rf /var/lib/apt/lists/\* * :  borra la lista de los paquetes que estan disponibles en repositorio.  
**Upgrade only one**
*sudo apt-get --only-upgrade install namePackage*: 
**Package .deb, .rpm, etc**
*sudo dpkg -i example.deb*

## Variable de entorno
 - Configurar variables desde la linea de comando solo afecta a la sesion actual.  
 - Variables Locales (o de Shell): Solo existen dentro del proceso de la terminal actual donde se crean. Los programas o scripts que se lancen desde esa terminal no las pueden ver.  
 - Variables de Entorno (o Ambientales): Se heredan. Cualquier script o proceso "hijo" que se lance desde esa terminal podrá leerlas.  
 - El comando `export` hace que la variable esté disponible para la sesión actual (shell) y para cualquier programa o subproceso que se abra desde esa ventana, pero no la guarda en el disco duro.  

`ENTORNO="produccion" ./mi_script.sh`: Esta variable solo estara disponible en el entorno del script, no esta disponible en el resto de los comando que se ejecuten en esa shell.  
`ENTORNO="produccion"`: Variable local.  
`export http_proxy=http://username:password@proxyserver.net:port/`   
`printenv` -> Muestra toda la lista de variables de entornos globales activas.     
`printenv VARIBLE` -> Muestra el valor de la varible.  
`unset VAR` -> Resetea el valor de la varible a su valor original.  
`set` -> Muestra todas las varibles (variables de entorno y variables locales del shell).  
`export PATH="$PATH:/opt/misprogramas"` -> En el archivo (~/.bashrc) se pone el codigo anterior. Esto solo afecta a la sesion usuario del actual.
La parte de la ruta `$PATH`: permite adicionar a los valores de $PATH el nuevo valor que se especifica.  
Para configurar variables para todo el sistema, es recomendable añadirlas a /etc/profile, /etc/bash.bashrc o /etc/environment

## Permission
The owner of a file can change the permissions for user ( u ), group ( g ), or others ( o ) by adding ( + ) or subtracting ( - ) the read, write, and execute permissions.
read ( r ), write(w), execute(x)  
-R (recursive option)  
`sudo chmod o=+rwx /var/www/html/`
## List permissions   
`ls -l /path/dir/`
The order is d(if is a dir) u(rwx)g(rwx)o(rwx)

- `Lectura (r) 4`:	Permite ver el contenido del archivo o listar un directorio.
- `Escritura (w) 2`:	Permite modificar el archivo o crear/borrar archivos en un directorio.
- `Ejecución (x) 1`:	Permite ejecutar un archivo como programa o entrar en un directorio.

    - 7 (4+2+1) = rwx (Acceso total)
    - 6 (4+2+0) = rw- (Lectura y escritura)
    - 5 (4+0+1) = r-x (Lectura y ejecución)
    - 4 (4+0+0) = r-- (Solo lectura)

### Esta cadena de 10 caracteres se divide así:
 Ej. cadena de permisos `-rwxr-xr--`  
 - El primer carácter: Indica el tipo ( - para archivo, d para directorio).
 - Los siguientes tres (rwx): Permisos del Propietario.
 - Los tres centrales (r-x): Permisos del Grupo.
 - Los tres finales (r--): Permisos de Otros.

***

## Descomprimir
**Extraer el archivo .tar.gz al directorio de trabajo actual:** <br>
<code>tar -xf filename.tar.gz</code><br>
Este comando extraerá (-x) el archivo (-f) especificado (en este caso, filename.tar.gz) al directorio actual. <br>
**Extraer el archivo .tar.gz a un directorio de trabajo diferente:**<br>
<code>tar -xf filename.tar.gz -C /home/user/files</code> <br>
**Comprimir con GZIP** <br>
<code>gzip filename.tar</code> <br>
**Descomprimir el archivo .tar.gz con gzip:** <br>
<code>gzip -d filename.tar</code> <br>
**Comprimir el archivo .tar y conservar la copia original:** <br>
<code>gzip -c filename.tar</code>
**Comprime el archivo .tar y guárdalo como un archivo diferente:** <br>
<code>gzip -c filename.tar > newfilename.tar.gz</code> <br>
**Comprimir varios archivos:** <br>
<code>gzip file1 file2</code> <br>
**Descomprimir múltiples archivos:** <br>
<code>gzip -d file1 file2</code> <br>
**Comprime todos los archivos de un directorio:** <br>
<code>gzip -r directory1</code><br>

****

# Gestión de usuarios y grupos en Linux
`nano /etc/group` : Show all the group 
In this document line by line show the gruop and user.  
`sambashare:x:129:lorenzo,pepe,juan` :  
`sambashare` : el nombre del grupo.  
`x` : una contraseña cifrada.  
`129` : el número de identificación del grupo **GID**  
`lorenzo,pepe,juan,` : es un listado de los usuarios que pertenecen al grupo separados por comas.  

### List the group 
`cut -d : -f 1 /etc/group`  
### Show which group the user belongs to
``cat /etc/group | grep nameUser | cut -d: -f1``  

### Crear y eliminar grupos
*sudo groupadd [grupo]* : create a new group.  
*sudo groupadd [grupo1], [grupo2], [grupo3]* : create many groups.  
*sudo groupdel [group]* : delete a group.  

## USER
`nano /etc/passwd` : show all the users.  
In this document show all user, the structure is:  
`userName:x:1000:1000:userName,,,:/home/userName:/bin/bash`  
`userName` : es el alias del usuario que utiliza para registrarse.  
`x` : representa que la contraseña cifrada se encuentra en `/etc/shadow`  
`1000` : es el número de identificación del usuario `UID`.  
`1000` : representa el número de identificación del grupo principal al que pertenece el usuario, lo que se conoce como GID.  
`userName,,,` : es la información adicional que has proporcionado al crear la cuenta en cuestión.  
`/home/lorenzo` : es la ruta de inicio del nuevo usuario, *el hogar del usuario.*  
`/bin/bash` : es el shell que utiliza el usuario en cuestión.  

#### Show all the user
`cat /etc/passwd | cut -d: -f1`  

### Crear y eliminar usuarios
sudo adduser [usuario]: create a user.  
sudo deluser [usuario]: delte a user.  

## Usuarios y grupos
*groups [usuario]*: show which group the user belongs to.  

### Add a user to a group
*sudo usermod -a -G [grupos] [usuario]*: La opcion `-a` (append) permite añadir el grupo a la lista de grupos del usuario. Sino se usa la opcion se saca de los demas grupos y solo se queda con el grupo recien añadido.  
### take out a user from a group
sudo deluser [usuario] [grupo]: Para sistemas Debian/Ubuntu  
sudo gpasswd -d [nombre_usuario] [nombre_grupo]: CentOS, Red Hat, Debian, Ubuntu   


***
## Free swap memory 
*sudo swapoff -a* : turn off and clean swap memory
*sudo swapon -a* : turn on swap memory


## SMB
#### smbclient  
Option -A: is to autenticate from a file, where are the param to log in.  
*smbclient  -A /file/where are param/smbclient_param  //10.7.1.67/Buzon\ Correos\ Seguridad(shared file)*  
**Format of parameter**  
username = fvelazquez  
password = MyPassword  
domain   = epepc.cupet.cu    

*smbclient -L server.ip   -U MyUsername -W domain*  

## SSH
*ssh user@ip.address –p7654*

## File
**df -h** -> "Disk Filesystem"  
**du** -> abreviación de "Disk Usage"  
**du** *[options]* *[location of directory or file]*  
**du -h /home/user/Desktop/ | sort –rn** -> ordenará todos los archivos y carpetas de mayor a menor.  
**du -h /home/user/Desktop | grep '^\s*[0-9\.]\+G'** -> todos los archivos mayores a 1 GB.M para mega.  
**du -h /home/user/Desktop/ --exclude="*.txt"** -> Excluir tipos de archivos.       

## File and Dir
`tree nombre-dir`: Muestra recursivamente la estructura de direcotrios contenidos en el directorio nombrado.  


## Certificados
- `curl --insecure -vvI <url> 2>&1 | awk 'BEGIN { cert=0 } /^\* SSL connection/ { cert=1 } /^\*/ { if (cert) print }'` : Muestra la info 

## Salidas (STDIN, STDOUT, STERR)
 - `STDIN`: El valor idendificador es 0. Es la entrada que recibe la consola, normalmente por teclado. Puede ser un archivo (Ej. `wc -l < archivo.log`, esto cuenta los saltos de lineas que tiene el archivo.log). Con el `<` se pasa como entrada (stdin) a `wc`.  
 - `STDOUT`: El valor idendificador es 1. Es la salida que da por consola. Con el `>` se usa para decir stdout. `printenv` la salida que muestra en consola es el stdout.  
 - `STDERR`: El valor idendificador es 2. Los valores stdout y stderr se muestran en la consola. Para redireccionar una salida se usa el identificador de cada std_. Ej. `ls -l 1> error.log`, esto redirecciona los errores que de el comando ls hacia el archivo error.log.  Si quisieramos mostrar solo los errores y no ver la salida estandar: `ls -l 1> /dev/null`, esto tira la salida estandar para null que es nada y solo muestra los errores.  

 - Elementos a tener en cuenta, el simbolo `>` borra todo el contenido del archivo donde se redirecciona la salida. Para adicionar nuevo contenido al ya existente se usa el simbolo `>>`.  

## Argumentos en script
   - Las variables numéricas en Bash funcionan así:$0: Nombre del script.$1: Primer parámetro.$2: Segundo parámetro.
     `./desplegar.sh staging rapido`: $0 será ./desplegar.sh, $1 será staging, $2 será rapido
