#Spring boot demo

This is a small spring boot 2 project to setup liquibase, postgres that runs in a docker (via docker-compose).

An custom actuator endpoint is also added just for testing purposes.

#Setup postgres database

To setup the databse, follow this [article](https://medium.com/analytics-vidhya/getting-started-with-postgresql-using-docker-compose-34d6b808c47c).

Start the database by running
>docker-compose up -d

## Connect to the Database

> docker-compose run database bash
> psql --host=database --username=demo --dbname=demo_database

### Liquibase

Liquibase setup following this [article](https://javadeveloperzone.com/spring-boot/spring-boot-liquibase-example/)

To run:
>mvn spring-boot run 