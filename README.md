
#PROJECT'S TITLE
       "Library Management"

#PROJECT'S DESCRIPTION
Our main goal with this project is to enable ease to the librarian working there and the students in search of new reads.
With this project the collection of data will be possible which allows easier and faster access to the needed information
in the process of borrowing a book.
Rather than putting up with the hassles of paper written data and manual search of the books, all of this can be done
from the comfort of their homes with a click.
The database of this project was done on PhpMyaAdmin, and then implemented on a SpringBoot Project java-based framework.


#HOW TO RUN THE APPLICATION

In order to run the application, you need to have a few things at hand, the development environment for Java that is
IntelliJ IDEA, the free, open-source XAMPP Server, the MySql Administration tool, PhpMyAdmin, and optionally you can 
get PostMan in order to test the different Mappings( GetMapping, PostMapping, PutMapping, DeleteMapping).
After unzipping the file and opening the Springboot and Java code in IntelliJ, importing the database in PhpMyAdmin and 
connecting the two. Then we turn on the Apache and MySQL servers on Xampp that allows us as localhost to test our application

#DATABASE

Our PhpMyAdmin Database consists 7 entities :

1)Book(bID	title	author	availability	phID)
2)Employee(eID  Name Surname  WorkingHours )
3)Member (mID	mName	mSurname	nrBooks	eID	rtID)
4)PublishingHouse(phID	Name	Address	nrBooks	)
5)ReadingTable(rtID	availability)
6)BorrowedBooks(dateofborrow returndate	bID	mID	)
7)TablesBooked(	tbID	bID	retID	)

#DEPENDENCIES
In pom.xml which is the fundamental unit of work in Maven, we write our dependencies that help us build our project

1)
```<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
   </dependency>
   ```

Used for securing the web application, automatically secures all http endpoints

2) 
```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
```
Provides starter and libraries for connecting an application with JDBC. In Spring Boot JDBC, provides most of the 
features we're used with Spring Data JPA like mapped entities, repositories, query annotations, and JdbcTemplate.


3)
```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
Spring Boot provides spring-boot-starter-data-jpa dependency to connect Spring application with relational database 
efficiently.

4)
```<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```

   
It is used for building the web application, including RESTful applications using Spring MVC. 
It uses Tomcat as the default embedded container.

5) 
```<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <version>8.0.27</version>
   </dependency>
```
The mysql-connector-java dependency is for the MySQL database driver. The spring-boot-maven-plugin provides 
Spring Boot support in Maven, allowing us to package executable JAR or WAR archives. Its spring-boot:run goal 
runs the Spring Boot application. resources/application.properties.

6)
```<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
</dependency>
```
The spring-boot-starter-test is the primary dependency that contains the majority of elements required for our tests. 
The H2 DB is our in-memory database. It eliminates the need for configuring and starting an actual database for test purposes.

7)
```<dependency>
   <groupId>org.hibernate</groupId>
   <artifactId>hibernate-core</artifactId>
   <version>6.0.0.Beta3</version>
   <type>pom</type>
   </dependency>
```
Hibernate is a Java framework that simplifies the development of Java application to interact with the database. 
It is an open source, lightweight, ORM (Object Relational Mapping) tool. 
Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.

#DDL SCRIPTS

Scripts used to create the database in PhpMyAdmin:
```
CREATE TABLE Employee
(
eID varchar(20),
name varchar(20),
surname varchar(20),
workinghours int,

	CONSTRAINT Employee_pk PRIMARY KEY(eID)
	)
```
```
CREATE TABLE ReadingTable
(
rtID varchar(20),
availability varchar(5)
CONSTRAINT ReadingTable_pk PRIMARY KEY (rtID)
)
```
```
CREATE TABLE Member
(

mID varchar(20),
mname varchar(20),
msurname varchar(20),
nr_books int,
eID varchar(20),
expirydate date,
rtID varchar(20),
CONSTRAINT Member_pk PRIMARY KEY (mID),
CONSTRAINT eID_Fk  FOREIGN KEY(eID) REFERENCES Employee(eID),
CONSTRAINT rtID_Fk  FOREIGN KEY(rtID) REFERENCES ReadingTable(rtID)
)
```
```
CREATE TABLE PublishingHouse
(
phID varchar(20),
name varchar(20),
address varchar(20),
nr_books int,
CONSTRAINT PublishingHouse_pk PRIMARY KEY(phID)
)
```
```
CREATE TABLE Book
(
bID varchar(20),
title varchar(30),
availability varchar(5),
author varchar(20),
field varchar(20),
phID varchar(20),
CONSTRAINT Book_pk PRIMARY KEY(bID),
CONSTRAINT phID_Fk  FOREIGN KEY(phID) REFERENCES PublishingHouse(phID)
)
```

```
CREATE TABLE BorrowedBooks
(
mID varchar(20),
bID varchar(20),
dateofborrowment date,
returndate date,
CONSTRAINT mID_Fk FOREIGN KEY(mID) REFERENCES Member(mID),
CONSTRAINT bID_Fk FOREIGN KEY(bID) REFERENCES Book(bID)
)
```
```
CREATE TABLE TablesBooked
(
rtID varchar(20),
bID varchar(20),
CONSTRAINT bID_Fok FOREIGN KEY(bID) REFERENCES Book(bID),
CONSTRAINT rtID_Fok FOREIGN KEY(rtID) REFERENCES ReadingTable(rtID)
)
```
#REST ENDPOINTS
REST stands for Representational State Transfer. In other words, REST APIs work by fielding requests
for a resource and returning all relevant information about the resource.

**Table Book Endpoints**

```
GET -> You are returned with a list of Books including their Id, Title, Author, Availability and phId(PublishingID)
GET http://localhost:8080/book/
GET http://localhost:8080/book/{{id}} (return a book with a certain ID)

POST-> Through Post we are enabled to input data into table Book in our database
POST http://localhost:8080/book

PUT -> Enables us to update a certain book through the given Id
PUT http://localhost:8080/book/{{id}}

DELETE-> Delete a certain book through the given Id
DELETE http://localhost:8080/book/{{id}}
```
**Table Employee Endpoints**

```
GET -> You are returned with a list of Employees including their Id, Name, Surname, WorkingHours
GET http://localhost:8080/employee
GET http://localhost:8080/employee/{{id}} (return an employee with a certain ID)

POST-> Through Post we are enabled to input data into table Employee in our database
POST http://localhost:8080/employee

PUT -> Enables us to update a certain employee through the given Id
PUT http://localhost:8080/employee/{{id}}

DELETE-> Delete a certain employee through the given Id
DELETE http://localhost:8080/employee/{{id}}
```

**Table Member Endpoints**

```
GET -> You are returned with a list of Member including their Id, Name, Surname, NrBooks
GET http://localhost:8080/member
GET http://localhost:8080/member/{{id}} (return a member with a certain ID)

POST-> Through Post we are enabled to input data into table Member in our database
POST http://localhost:8080/member

PUT -> Enables us to update a certain member through the given Id
PUT http://localhost:8080/member/{{id}}

DELETE-> Delete a certain member through the given Id
DELETE http://localhost:8080/member/{{id}}
```
**Table PublishingHouse Endpoints**

```
GET -> You are returned with a list of PublishingHouses including their Id, Name, Address, NrBooks
GET http://localhost:8080/publishinghouse
GET http://localhost:8080/publishinghouse/{{id}} (return a publishinghouse with a certain ID)

POST-> Through Post we are enabled to input data into table PublishingHouse in our database
POST http://localhost:8080/publishinghouse

PUT -> Enables us to update a certain publishinghouse through the given Id
PUT http://localhost:8080/publishinghouse/{{id}}

DELETE-> Delete a certain publishinghouse through the given Id
DELETE http://localhost:8080/publishinghouse/{{id}}
```
**Table ReadingTable Endpoints**

```
GET -> You are returned with a list of ReadingTables including their Id and Availability
GET http://localhost:8080/readingtable
GET http://localhost:8080/readingtable/{{id}} (return a readingtable with a certain ID)

POST-> Through Post we are enabled to input data into table ReadingTable in our database
POST http://localhost:8080/readingtable

PUT -> Enables us to update a certain readingtable through the given Id
PUT http://localhost:8080/readingtable/{{id}}

DELETE-> Delete a certain readingtable through the given Id
DELETE http://localhost:8080/readingtable/{{id}}
```
