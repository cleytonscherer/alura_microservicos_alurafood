1) Subir primeiro o projeto ms-server, ele vai startar o compose.yml
2) Seja paciente, o banco de dados mysql demora para subir
3) Para visualizar as conexões, usar http://localhost:8081/
4) Para corrigir o erro de login do mysql via docker: https://stackoverflow.com/questions/76749414/access-denied-for-user-when-creating-mysql-database-with-docker
5) Para adicionar novo status na tabela pagamentos: ALTER TABLE pagamentos  MODIFY COLUMN status ENUM('CANCELADO','CONFIRMADO','CONFIRMADO_SEM_INTEGRACAO','CRIADO')

docker run -e MYSQL_DATABASE=alurafood_pagamento -e MYSQL_PASSWORD=alurafood123 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=alurafood -p 3306:3306 -d mysql:8.0.39

docker run -e POSTGRES_DB=alurafood_pedido -e POSTGRES_USER=alurafood -e POSTGRES_PASSWORD=alurafood123 -e PGDATA=/var/lib/postgresql/data -p 5432:5432 -d postgres:14

# latest RabbitMQ 3.13.17
docker run -it -e RABBITMQ_ENABLED_PLUGINS=rabbitmq_shovel_management,rabbitmq_shovel --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13.7-management

# Ativando plugins iterativamente
docker exec -it rabbitmq rabbitmq-plugins enable rabbitmq_shovel rabbitmq_shovel_management

https://medium.com/@kaloyanmanev/how-to-run-rabbitmq-in-docker-compose-e5baccc3e644
https://stackoverflow.com/questions/52819237/how-to-add-plugin-to-rabbitmq-docker-image
https://github.com/mpolinowski/rabbitmq-mqtt-ws-docker/blob/master/docker-compose.yml


# RabbiqMQ Management
# user: guest
# password: guest
http://localhost:15672/