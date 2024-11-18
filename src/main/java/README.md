# SnapMart
![60d0f685e4661743bd213cb3_Effective-school-administration-supports-databased-decision-making_896_6065058_0_14102171_1000](https://github.com/Sowndarya9920/Student_management_system/assets/112794922/1d9d7146-1ff1-4be3-8d6e-5c4fc0275dbf)


##### 🔸The SnapMart system you have built using the Spring Boot framework is designed to handle basic CRUD (Create, Read, Update, Delete) operations for managing order records.
## :one: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
    4. H2 Database

## :two: Dependency Used
    1. Spring Web
    2. Spring Boot Dev Tools
    3. Lombok
    4. Spring Data JPA
    5. H2
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :three: Dataflow (Functions Used In)
### :white_flower: 1. Model - This used to show the mirror of our database which involves real world entities.
#### :1: Customer.java
#### :2: Order.java
#### :3: Product.java
#### :4: Seller.java

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### :white_flower: 2. Service - This Layer is used to perform business functionalities.
#### :1: CustomerService.java
#### :2: OrderService.java
#### :3: ProductService.java
#### :4: SellerService.java

----------------------------------------------------------------------------------------------------------------------------------------------------

### :white_flower: 3. Controller - This Controller is used to create RestApi's and perform basic CRUD operations.
#### :1: CustomerController.java
#### :2: OrderController.java
#### :3: ProductController.java
#### :4: SellerController.java

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :white_flower: 4. Repository : data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanisms.
#### :1: CustomerRepository.java
#### :2: OrderRepository.java
#### :3: ProductRepository.java
#### :4: SellerRepository.java

-------------------------------------------------------------------------------------------------------------------------------------------------------
### :white_flower: 5. Application.properties File : The application.properties file in Spring Boot is a configuration file used to specify various settings and properties for the application.
```java
        spring.application.name=SnapMart

        spring.datasource.url=jdbc:mysql://localhost:3306/snapmart
        spring.datasource.username=root
        spring.datasource.password=root
        spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

        #jpa configuration


        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
        spring.jpa.hibernate.ddl-auto=create
        spring.jpa.show-sql=true

        #email configuration

        spring.mail.host=smtp.gmail.com
        spring.mail.port=587
        spring.mail.username=mmausheen3654@gmail.com
        spring.mail.password=znknbpdkwtxrvobg
        spring.mail.properties.mail.smtp.auth=true
        spring.mail.properties.mail.smtp.starttls.enable=true
```
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :five: Test Rest Api's
#### :white_check_mark: SnapMart Controller
```java
http://localhost:8080/api/v1/seller
```

```java
http://localhost:8080/api/v1/product
```

```java
http://localhost:8080/api/v1/customer
```

```java
http://localhost:8080/api/v1/order
```

#  Summary
- :small_orange_diamond: Implemented basic CRUD operations (Create, Read, Update, Delete) to manage seller and customer (product,order), and you utilized the H2 database for storing and manipulating the data.
- :small_orange_diamond: The system allows you to create new Seller,Order,Customer,Product records, retrieve existing records based on various criteria,all using the H2 database as the underlying storage.