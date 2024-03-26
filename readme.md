PostgreSQL 14.4 и выше

Java 17 и выше

Swagger располагается по адресу:
http://localhost:8080/swagger-ui/index.html

Если таблица (agima) пустая,скрипт liquibase наполнит её 10млн записями ( выполняется рпи каждом запуске приложения)

Настройка базы данных осуществляется путём указания настроек:

````yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/database-name
    username: login
    password: pawword
````

Команда для запуска приложения

````shell
java -jar test-app-2-1.0-SNAPSHOT.jar
````

Логи находятся в тут:

\logs\TEST-APP-LOG.log