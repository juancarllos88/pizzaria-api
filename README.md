# Pizzaria-Api
Api para uma pizzaria usando spring Boot


## Passo a Passo para subir a aplicação:
- Instalar o docker
- Criação da network
-- executar: **docker network create --driver bridge network-pizzaria**
- Criação do banco PostgreSql
-- executar: **docker container run --name postgres-pizza --network=network-pizzaria -p 5432:5432 -e POSTGRES_DB=pizzaria -e POSTGRES_USER=pizza -e POSTGRES_PASSWORD=pizza -e TZ=GMT postgres:9.6**
- Criei uma imagem e fiz o pull para o docker hub
-- executar: **docker container run --name pizzaria --network=network-pizzaria -p 8020:8020 juancarllos88/pizzaria-core**

## Testando a API
#####`<link>` : <http://localhost:8020/swagger-ui.html>


##Consumo da API

> **Utilize o token:
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaXN0ZW1hIiwiY3JlYXRlZCI6MTU2NDQ1MDIzMjE3Niwicm9sZXMiOlsiUk9MRV9TSVNURU1BIl0sImlkIjoxfQ.3yJke6Y-PedvHvmGiIh19U3US8PL7gG3ac2zL_ws6tpc0q2frZVWdPOSsdip7mOeDhvjbeB_wuH7LcITOwoNeA**




