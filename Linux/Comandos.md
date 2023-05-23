## Variable de entorno para proxy
<code>export http_proxy=http://username:password@proxyserver.net:port/ </code>
## Permission
The owner of a file can change the permissions for user ( u ), group ( g ), or others ( o ) by adding ( + ) or subtracting ( - ) the read, write, and execute permissions.
read ( r ), write(w), execute(x)<br>
-R (recursive option) <br>
<code>sudo chmod o=+rwx /var/www/html/</code> <br>
**List permissions**<br>
<code>ls -l /path/dir/</code> 

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

