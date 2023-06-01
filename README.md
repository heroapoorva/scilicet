# scilicet
Code repo for Scilicet app for sparity

# source for installation
Currently setting up using this tutorial https://spring.io/guides/gs/spring-boot/#scratch

# Usage
Install dependencies like Java, Maven, Psql
  Update database, user and password in the src/main/resources/application.properties file
  cd into the spring-boot directory and run

    ./mvnw spring-boot:run

This creates a localhost server on port 8080.
  curl this at different endpoints to test different functionalities.
  Currently, when the server is started, the app runs a create table query in postgres inferred from the definition from the Students.java class.

# Endpoints
1) `/`   
    `curl localhost:8080`   
  This is an endpoint to check if configuration works.

2) `/jdbc_insert`   
    `curl localhost:8080/jdbc_insert`   
  This endpoint is implemented using JDBC.   
  This inserts a row into the students table in the database provided in the URL in application.properties file.

3) `/jpa_select`   
    `curl localhost:8080/jpa_select`   
  This endpoint is implemented using JPA.   
  This runs a count query against the students table and returns the number of rows in the table.

4) `/jpa_insert`   
    `curl localhost:8080/jpa_insert`   
  First, we create a student object and pass in the arguments for all attributes except "ID" which is the primary key because it is auto inferred.   
  This endpoint is implemented using JPA.   


# Decisions/Learnings
1) I am using Maven instead of Gradle, I was able to get Maven working with less debugging.
2) I am using Lombok to not have to write getters and setters
3) I am using JPA as an ORM to not have to write raw SQL statements.
4) I am using Hibernate, as it takes cares few things, like, creating a table when it does not exist and I have defined it.
5) I am using jakarta instead of javax to define Students. Javax caused issues with creating beans.

# TODOs
1) Add logging. 
  It was decided to use **logback**. https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/boot-features-logging.html
2) Add unit testing. 
  Do we have minimum percentage requirements?
3) Use Swagger API.
  Need to research this.
