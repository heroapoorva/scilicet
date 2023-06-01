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

1) /
This is an endpoint to check if configuration works.

2) /jdbc_insert
This endpoint is implemented using JDBC connection.
This inserts a row into the students table in the database provided in the URL in application.properties file.

3) /jpa_select
This endpoint is implemented using JPA.
This runs a count query against the students table and returns the number of rows in the table.

4) /jpa_insert
This endpoint is implemented using JPA.
First, we create a student object and pass in the arguments for all attributes except "ID" which is the primary key because it is auto inferred.
 