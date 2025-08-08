docker run -e MYSQL_DATABASE=alurafood_pagamento -e MYSQL_PASSWORD=alurafood123 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=alurafood -p 3306:3306 -d mysql:8.0.39

docker run -e POSTGRES_DB=alurafood_pedido -e POSTGRES_USER=alurafood -e POSTGRES_PASSWORD=alurafood123 -p 5432:5432 -d postgres:14