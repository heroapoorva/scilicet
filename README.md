# scilicet
Code repo for Scilicet app for sparity

# source for installation
Currently setting up using this tutorial https://spring.io/guides/gs/spring-boot/#scratch

# Dependencies
Need to install Java, Maven and Postgres SQL
Create a database in Postgres, create a username and password which the spring-boot is going to use to interact with psql. Update the URL, username and password in the src/main/resources/application.properties file

# Usage
To start the server,   
  cd into the spring-boot directory and run

    ./mvnw spring-boot:run

This creates a localhost server on port 8080.
  curl this at different endpoints to test different functionalities.
  Currently, when the server is started, the app runs a create table query in postgres inferred from the definition from the Students.java class.

To run unit tests, go into the spring-boot directory and rune the command

    mvn test

To go to the swagger-ui 

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

5) /


# Decisions/Learnings
1) I am using Maven instead of Gradle, I was able to get Maven working with less debugging.
2) I am using Lombok to not have to write getters and setters
3) I am using JPA as an ORM to not have to write raw SQL statements.
4) I am using Hibernate, as it takes cares few things, like, creating a table when it does not exist and I have defined it.
5) I am using jakarta instead of javax to define Students. Javax caused issues with creating beans.
6) I am using logging level at INFO. Setting it to trace blows up the size too much.
7) I am currently logging to STDOUT and the logging directory.

# TODOs
1) Send logs to syslog.
3) Use Swagger API.   
  Need to research this.
