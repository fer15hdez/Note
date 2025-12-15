# Kubernetes

## Comandos
 -  kubectl apply -f <nombre_del_archivo.yaml> : aplicar manifiesto(archivo).   
## Service
- El Service es un objeto fundamental que actúa como un enlace permanente y un balanceador de carga para un grupo de Pods.  
- El Service toma la lista de direcciones IP de todos los Pods que lo respaldan y presenta una única IP virtual (ClusterIP) y un nombre DNS estable a otros Pods o servicios dentro del clúster.  
## Tipos de service
- `ClusterIP`: 
   - Uso Principal:	Comunicación interna entre aplicaciones dentro del mismo clúster de K8s.  
   - Funcionamiento: Proporciona una IP virtual dentro del clúster (la ClusterIP).  
   - Accesibilidad:	Solo se puede acceder a este Service desde dentro del clúster.  
   - Ejemplo: Un frontend necesita comunicarse con un backend o una base de datos.  
- `NodePort`: Abre un puerto estático en todos los nodos (Workers). El tráfico se dirige al puerto del nodo: `IP_del_Nodo`:`Puerto_del_Nodo`. Cada nodo redirige internamente al Service.  
   - Uso Principal: Exponer un Service al exterior mediante un puerto específico en cada nodo del clúster.  
   - Funcionamiento: Además de una ClusterIP, abre un puerto estático (el NodePort) en el rango por defecto (30000-32767) en todos los nodos del clúster.  
   - Accesibilidad: Se puede acceder al Service desde fuera del clúster a través de: http://<IP_del_Nodo>:<NodePort>.  
   - 
- `LoadBalancer`: Provisiona un balanceador de carga externo. El Service solicita una IP pública y estable al proveedor de la nube (AWS, GCP, Azure), que distribuye el tráfico entre los nodos.  

## INGRESS
- Es un objeto de API que actúa como una "puerta de entrada" inteligente al clúster. Mientras que un Service se encarga de conectar tráfico a nivel de red (Capa 4 - TCP/UDP), el Ingress gestiona el acceso externo a los servicios a nivel de aplicación (Capa 7 - HTTP/HTTPS).  
- Componentes importantes:
  - Ingress Resource (El Recurso): Es un archivo YAML donde defines las reglas de enrutamiento (ej: "si el tráfico viene a myapp.com/api, envíalo al Service A").  
  - Ingress Controller (El Controlador): Es el software que realmente ejecuta esas reglas. A diferencia de otros controladores en K8s, este no viene instalado por defecto. Debes elegir e instalar uno (como Nginx, Traefik, HAProxy o Kong).  

## Pods
- IPs Volátiles: La dirección IP de un Pod es efímera. Cuando un Pod muere y es reemplazado por uno nuevo, incluso si tienen el mismo nombre y etiquetas, el nuevo Pod tendrá una IP diferente.  

### Comandos
- `kubectl get nodes -o wide`: Encontrar la IP del nodo.  
- `kubectl get pods -o wide`:  Encontrar la IP del pod.  
- `kubectl get service <nombre-del-servicio> -o yaml`: Obtener los puertos si el servicio es de tipo NodePort.  
- `kubectl describe pod <nombre-del-pod>`:  Ver detalles de la IP.  
- `kubectl logs <nombre-del-pod>`: Ver los logs del contenedor y verificar si hay información sobre los puerto.  
- `kubectl delete pod <pod-name>`: Eliminar un pod.  
- `kubectl delete pods -l <etiqueta>=<valor>`: Eliminar los pods que tienen la <etiqueta>=<valor>.  
- `kubectl delete pods -n <espacio-de-nombres>`: Eliminar los pods por namespace.  

## Namespace
### Comandos
- `kubectl.exe get namespace`: Lista los namespace.   

### Comados deployments
- `kubectl get deployments`: Lista los deployments.  
- `kubectl get deploy`: Lista más concisa.  
- `kubectl rollout status deployment/<nombre-del-deployment>`: Para ver el estado de un deployment específico.  
- `kubectl describe deployment/<nombre-del-deployment>`: Muestra los valores del deployment.  
- `kubectl rollout restart deployment <nombre-del-deployment>`: inicia un reinicio progresivo de los pods, creando nuevos pods y terminando los antiguos de manera controlada, según la estrategia de reinicio de la implementación. 

### Interactuar dentro de un Pods
- `kubectl exec -it <nombre-del-pod> -- /bin/sh`

## Jobs
### Comandos
- `kubectl delete job <nombre-del-job>`: Elimina el Job y sus Pods (comportamiento en cascada).  
- `kubectl delete job <nombre-del-job> -n <namespace>`: Para un Job en un namespace específico.  
- Si creaste el Job con un archivo YAML, usa `kubectl delete -f <archivo.yaml>`.  
- `kubectl get jobs`: Listar todos los Jobs.  
- `kubectl get jobs -n produccion`: Listar Jobs en un namespace específico (ej. produccion).  
- `kubectl get jobs --show-labels`: Listar Jobs y sus Pods relacionados (con más detalle).  
- `kubectl describe job <nombre-del-job>`: Ver detalles de un Job específico.  
- `kubectl get pods --selector=job-name=<nombre-del-job>`: Ver los Pods que ha creado un Job.  
- `kubectl logs <nombre-del-pod-del-job>`: Ver los logs de un Job (necesitas el nombre del pod).  
- ``

## CronJobs 
### Comandos
- `kubectl get cronjobs`: Listar todos los CronJobs.  
- `kubectl get cronjobs -n <nombre-del-namespace>`: Listar CronJobs en un namespace específico.  
- `kubectl describe cronjob <nombre-del-cronjob>`: Ver detalles de un CronJob.  
- `kubectl get jobs --selector=job-name=<nombre-del-cronjob>`: Ver los Jobs creados por un CronJob. 