1) Subir primeiro o projeto ms-server, ele vai startar o compose.yml
2) Seja paciente, o banco de dados mysql demora para subir
3) Para visualizar as conexões, usar http://localhost:8081/
4) Para corrigir o erro de login do mysql via docker: https://stackoverflow.com/questions/76749414/access-denied-for-user-when-creating-mysql-database-with-docker

docker run -e MYSQL_DATABASE=alurafood_pagamento -e MYSQL_PASSWORD=alurafood123 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=alurafood -p 3306:3306 -d mysql:8.0.39

docker run -e POSTGRES_DB=alurafood_pedido -e POSTGRES_USER=alurafood -e POSTGRES_PASSWORD=alurafood123 -e PGDATA=/var/lib/postgresql/data -p 5432:5432 -d postgres:14