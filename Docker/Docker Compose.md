# Docker Compose

## Volumenes
```yml 
    version: '3.8'
    services:
    web:
        image: nginx:latest
        volumes:
        - mi_volumen_datos:/usr/share/nginx/html  # Vinculación del volumen

    volumes:
      mi_volumen_datos:  # Definición del volumen nombrado
```

 - `Volúmenes Nombrados`: Se gestionan por Docker y se definen en la sección superior volumes: para persistencia de alto nivel.  
    ```yml
    volumes:
        - nombre_volumen:/ruta/en/contenedor
    ```

 - `Bind Mounts (Montajes de enlace)`: Mapean una carpeta específica del ordenador host al contenedor. Se usa una ruta local (./data) en lugar de un nombre.   
    ```yml
      volumes:
        - ./carpeta/local:/ruta/en/contenedor

    ```

- Volúmenes Externos: Puedes usar un volumen creado fuera de Compose añadiendo `external: true` en la definición.  
- Permisos: Los montajes de enlace (bind mounts) pueden tener problemas de permisos entre host y contenedor, mientras que los volúmenes nombrados no.     

### Montar volumenes externos
 - Define el volumen en la sección volumes del nivel raíz con `external: true`  
 - Móntalo en el servicio correspondiente.  
 ```yml    
    services:
    web:
        image: nginx:latest
        volumes:
        - mi_volumen_externo:/ruta/en/contenedor # <nombre>:<ruta_contenedor>

    volumes:
      mi_volumen_externo:
        external: true # <--- CLAVE: Indica que ya fue creado

 ```
  - Volumen no encontrado: Si el volumen no existe al lanzar docker-compose up, obtendrás un error.  