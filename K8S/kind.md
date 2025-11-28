# KinD (kubernetes in docker)

## Instal kind (kubernetes in docker)
- `go install sigs.k8s.io/kind@v0.30.0`: si tiene instaldo go.  

## Crear cluster con kind
- `kind create cluster --name cluster.test`: crea un cluster con el nombre "cluster.test". 

## Loading an Image Into Your Cluster
- `kind load docker-image my-custom-image:unique-tag --name nameCluster`