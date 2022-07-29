# vendas
Sistema de vendas destinado a pratica de diversas tecnologias 

## Start minikube
minikube start

## Iniciar Banco de dados
### A partir da pasta k8s excutar os seguintes comandos

kubectl apply -f ./db-fornecedores-configmap.yaml
kubectl apply -f ./db-fornecedores-pod.yaml
kubectl apply -f ./db-fornecedores-svc.yaml

kubectl port-forward service/db-fornecedores-svc 5432:5432


