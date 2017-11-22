avenuecode
===================

Arquive file with instructions how to compile, run and run automated tests

----------

Run the application
-------------
> mvn spring-boot:run

>To Create, Update, get and delete product use HTTP verbs like

localhost:8080/product (POST method) to save
eg:
{
	"name": "wine",
	"description": "alcoolic drink"
}

>to save product with father product 
eg:
{
	"name": "wine2",
	"description": "Bebida alcoolica",
	"father":{"id":<<father product id>>}
}

localhost:8080/product/{id} (GET method) to get a specific product

localhost:8080/product/{id} (DELETE method) to delete a specific product

> get the product with all child product and images

http://localhost:8080/product-with-relation/<<product id>>

> to get all products with relationship 

http://localhost:8080/product-with-relation/


To Create, Update, get and delete image use HTTP verbs like

> to save 

localhost:8080/image (PUT method) to save
{
	"product":{"id":<<product id>>}
}

localhost:8080/image/{id} (GET method) to get a specific product
localhost:8080/image/{id} (DELETE method) to delete a specific product

> to get all image by product id

http://localhost:8080/image-by-product-id/<<product id>>

----------


Run Tests
-------------
> mvn test