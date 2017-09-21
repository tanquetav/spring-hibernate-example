# spring-hibernate-example

Exemplo spring hibernate

configurar usuario e senha de banco de dados em src/main/resource/application.properties

para rodar:

./gradlew bootRun


para buildar:

./gradlew bootRepackage

vai gerar um pacote com tudo em build/libs/spring-hibernate-example-0.0.1-SNAPSHOT.jar

basta entao dar um java -jar build/libs/spring-hibernate-example-0.0.1-SNAPSHOT.jar


Os bancos, para carregar no example e example2 estao no doc/ddl.sql

E o comando piada pronta:

curl -H 'Content-Type: application/json' -H 'X-Tenant: othe' 'http://localhost:8080/product'


