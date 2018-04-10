# Build

## Database: MySQL v5.7.21

First of all you have to install the database. This application uses MySQL v5.7.21. Once the database is installed, you must create the "flight" schema with the following sql command: `create schema flight`

Once you have created the scheme, you do not have to do anything else. When the application run, it will create all the tables and insert test data through a continuous integration system called liquibase.

## Environment installation

Clone the following two repositories in your workspace:

`git clone https://github.com/slavcho87/flight-config`

`git clone https://github.com/slavcho87/flight` 

The master branch carries the most stable version. Access in `https://github.com/slavcho87/flight` repository and import the project as a normal maven project.

# Run

## Run as a normal java application

For the correct execution of the application, the following must be executed in classes in the order described:

1. Run flight.configuration.ConfigServer.java: spring cloud configuration server
2. Run com.flight.manager.ApplicationStarter: the flight manager provides information about the cities and their flights 
3. Run com.flight.analist.ApplicationStarter: the flight analyst is an intelligent agent run by AI that provides the fastest route to fly from city 'X' to 'Y'

# Use

To launch calls to the API, you can be any rest client. I used Postman (https://www.getpostman.com/apps). 

To obtain more information please consult the official documentation of each component available in the following URL:

- http://localhost:8091/swagger-ui.html: Rest API Flight Manager
- http://localhost:8092/swagger-ui.html: Rest API Flight Analist

# Technologies used

In this project the following technologies have been used:

- Java 1.8
- Liquibase v3.6.0: continuous integration of the database
- spring boot v1.5.11.RELEASE
- spring cloud 1.4.3.RELEASE
- aima-java v3.0.0: framework that contains artificial intelligence algorithms
- swagger v2.8.0: framework to document rest api

