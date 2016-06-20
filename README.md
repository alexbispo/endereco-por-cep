endereco-por-cep
==========================================================

Web service para busca de endereço por CEP, dado um CEP válido, retorna o endereço conrrespondente.

## Requerimentos

 - [Java Development Kit(JDK)](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) >= 1.7
 - [Apache Maven](https://maven.apache.org/) 3.3.9


Conteúdo
--------

Abaixo, o mapeamento das rotas do serviço:

URI path                        | Resource class            | HTTP methods
------------------------------- | ------------------------- | --------------
**_/enderecos/{cep}_**          | EnderecoResource            | GET

Rodando a aplicação
-------------------

Execute os seguintes comandos:

>     mvn clean package jetty:run

Isso irá fazer o deploy da aplicação usando o Jetty web server. Feito o deploy,
busque um endereço por cep, como no exemplo abaixo: 

-   <http://localhost:8080/enderecos/12345678>
