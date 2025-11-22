Esse foi meu Creditall Challenge, fiz um sistema simples de cadastro e gestão que contém:
- Produtos
- Clientes
- Vendas

A aplicação foi constuída utilizando Java 17, Spring Boot, MySQL, Spring Data e Maven.

Como Rodar o Projeto:

1 - Configure o banco de dados MySQL

Crie um banco: "CREATE DATABASE creditall_db;"

2 - Ajuste o Application.properties: 

----
spring.datasource.url=jdbc:mysql://localhost:3306/creditall_db

spring.datasource.username=root

spring.datasource.password=SUASENHA

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

--------
3 - Rodar no IntelliJ ou no terminal: mvn spring-boot:run

A API ficará disponível em: http://localhost:8080

Endpoints da API
-

Produtos
-

Criar produto: POST/products

Buscar todos: GET/products

Buscar por ID: GET/products/{id}

Atualizar: PUT/products/{id}

Deletar: DELETE/products/{id}

Clientes
-

Criar clientes : POST/clients

Sales
-

Criar venda: POST/sales

-----

Observações: 
-

- O projeto cumpre todos os requisitos obrigatórios do desafio
- Implementações dos opcionais podem ser adcionadas futuramente