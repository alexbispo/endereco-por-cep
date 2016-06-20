endereco-por-cep
==========================================================

Web service para busca de endereço por CEP, dado um CEP válido, retorna o endereço correspondente.

## Requerimentos

 - [Java Development Kit(JDK)](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) >= 1.7
 - [Apache Maven](https://maven.apache.org/) 3.3.9

## Comportamento

 - Dado um CEP válido, retorna o endereço correspondente
 - Dado um CEP válido, que não exista o endereço, substitui um digito da direita para a esquerda por zero até que o endereço seja localizado
   (Exemplo: Dado 22333999 tenta com 22333990 22333900 ...)
 - Dado um CEP inválido, retorna mensagem: "CEP inválido"

Rotas
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
