This REST program actually consists of three nearly totally independent basic CRUD projects.
One can communicate with the database using three different technologies. You can simply 
change between the different ORM tools using the following URL-s:
Spring Data Jpa - "/api"
Hibernate - "/hibernate"
Jpa  - "/Jpa"
Spring AOP makes it possible to follow the parallel executions. Search for the "@Before" and 
the "@AfterReturning" messages in the console.

I also used AOP to measure how long it takes to perform each operation.
 The result can be found on the console after the "@Around" message.

The program uses h2 database. The initial data can be found in the
 data.sql file in the src/main/resources folder.
 
 Exception handling tries to handle wrong requests.

 There is also a very basic actuator endpoint management in the program.