# Limitar uso recurso
`sudo systemctl edit snapd(este es el servicio)`
En el archivo override.conf que sale por defecto poner lo siguiente  

`[Service]`
`CPUQuota=20%`         # Límite de CPU al 20%  
`MemoryMax=512M`       # Límite de memoria a 512MB  
`MemorySwapMax=1G`     # Límite de swap a 1GB (opcional)  

# Recargar systemd y reiniciar el servicio:
`sudo systemctl daemon-reexec`    # Recarga la configuración de systemd
`sudo systemctl restart snapd`    # Reinicia el servicio `snapd`

# Verificar que los límites se han aplicado correctamente:
`systemctl show snapd | grep CPUQuota`      # Verifica el límite de CPU
`systemctl show snapd | grep -i memory`    # Verifica el límite de memoria

# Posible resultado
CPUQuota=20%          # CPU limitado al 20%
MemoryMax=536870912   # Memoria limitada a 512MB
MemorySwapMax=1073741824  # Swap limitado a 1GB (si lo pusiste)





