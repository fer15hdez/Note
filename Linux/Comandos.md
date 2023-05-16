##Variable de entorno para proxy
<code>export http_proxy=http://username:password@proxyserver.net:port/ </code>
## Permission
The owner of a file can change the permissions for user ( u ), group ( g ), or others ( o ) by adding ( + ) or subtracting ( - ) the read, write, and execute permissions.
read ( r ), write(w), execute(x)<br>
-R (recursive option) <br>
<code>sudo chmod o=+rwx /var/www/html/</code> <br>
**List permissions**<br>
<code>ls -l /path/dir/</code> 