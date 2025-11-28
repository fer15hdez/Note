# Kubernetes

## Comandos
 -  kubectl apply -f <nombre_del_archivo.yaml> : aplicar manifiesto(archivo).   
## Service
- El Service es un objeto fundamental que actúa como un enlace permanente y un balanceador de carga para un grupo de Pods.  
- El Service toma la lista de direcciones IP de todos los Pods que lo respaldan y presenta una única IP virtual (ClusterIP) y un nombre DNS estable a otros Pods o servicios dentro del clúster.  
## Tipos de service
- `ClusterIP`: 
- `NodePort`: Abre un puerto estático en todos los nodos (Workers). El tráfico se dirige al puerto del nodo: `IP_del_Nodo`:`Puerto_del_Nodo`. Cada nodo redirige internamente al Service.  
- `LoadBalancer`: Provisiona un balanceador de carga externo. El Service solicita una IP pública y estable al proveedor de la nube (AWS, GCP, Azure), que distribuye el tráfico entre los nodos.  

### Comandos
- `kubectl get nodes -o wide`: Encontrar la IP del nodo.  
- `kubectl get pods -o wide`:  Encontrar la IP del pod.  
- `kubectl get service <nombre-del-servicio> -o yaml`: Obtener los puertos si el servicio es de tipo NodePort.  
- `kubectl describe pod <nombre-del-pod>`:  Ver detalles de la IP.  
- `kubectl logs <nombre-del-pod>`: Ver los logs del contenedor y verificar si hay información sobre los puerto.  
- `kubectl delete pod <pod-name>`: Eliminar un pod.  
- `kubectl delete pods -l <etiqueta>=<valor>`: Eliminar los pods que tienen la <etiqueta>=<valor>.  
- `kubectl delete pods -n <espacio-de-nombres>`: Eliminar los pods por namespace.  

### Comados deployments
- `kubectl get deployments`: Lista los deployments.  
- `kubectl get deploy`: Lista más concisa.  
- `kubectl rollout status deployment/<nombre-del-deployment>`: Para ver el estado de un deployment específico.  
- `kubectl describe deployment/<nombre-del-deployment>`: Muestra los valores del deployment.  
- `kubectl rollout restart deployment <nombre-del-deployment>`: inicia un reinicio progresivo de los pods, creando nuevos pods y terminando los antiguos de manera controlada, según la estrategia de reinicio de la implementación. 