# TodoList com Spring Boot, Kafka, MongoDB e WebFlux

Este é um exemplo de aplicação Spring Boot que implementa um TodoList utilizando conceitos de programação reativa com o Spring WebFlux no Padrão Builder.

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

- Java 11 ou superior
- Gradle
- Kafka
- MongoDB

## Configuração

Antes de executar a aplicação, é necessário configurar o Kafka e o MongoDB. Certifique-se de ter o Kafka e o MongoDB em execução localmente ou configure as propriedades `spring.kafka.bootstrap-servers` e `spring.data.mongodb.uri` no arquivo `application.properties` conforme necessário.

```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.data.mongodb.uri=mongodb://localhost:27017/tasks
```

## Executando a Aplicação

Para executar a aplicação, você pode usar o Gradle Wrapper fornecido com o projeto. Basta navegar até o diretório raiz da aplicação e executar o seguinte comando:

```bash
./gradlew bootRun
```

Isso iniciará a aplicação Spring Boot.

## Endpoints da API

A API oferece os seguintes endpoints:

- `GET /http://localhost:8080/task`: Retorna a lista de todos os itens do TodoList.
- `GET /http://localhost:8080/task?priority=0&pageNumber=0&pageSize=10`: Retorna com Paginação.
- `POST /http://localhost:8080/task`: Cria um novo item no TodoList.
- `GET /todos/{id}`: Retorna um item específico do TodoList com o ID correspondente.
- `PUT /todos/{id}`: Atualiza um item existente no TodoList com o ID correspondente.
- `DELETE /todos/{id}`: Remove um item do TodoList com o ID correspondente.

## Testando a Aplicação

Para executar os testes unitários, você pode usar o seguinte comando:

```bash
./gradlew test
```

Isso irá executar os testes JUnit da aplicação.

---