avenuecode
===================

Arquive file with instructions how to compile, run and run automated tests

----------


Run the application
-------------
> mvn spring-boot:run

To Create, Update, get and delete product use HTTP verbs like

localhost:8080/product (PUT method) to save
localhost:8080/product/{id} (GET method) to get a specific product
localhost:8080/product/{id} (DELETE method) to delete a specific product


To Create, Update, get and delete image use HTTP verbs like

localhost:8080/image (PUT method) to save
localhost:8080/image/{id} (GET method) to get a specific product
localhost:8080/image/{id} (DELETE method) to delete a specific product

----------


Run Tests
-------------
> mvn test