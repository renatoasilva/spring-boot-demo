# Spring boot demo

This is a small spring boot 2 project to setup liquibase, postgres that runs in a docker (via docker-compose).

An custom actuator endpoint is also added just for testing purposes.

# Setup postgres database

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


## Security

* Setup some security following this [article](https://www.callicoder.com/spring-boot-actuator/#securing-actuator-endpoints-with-spring-security)

## Customise error response

Setup a custom error, following this [article](https://dzone.com/articles/customize-error-responses-in-spring-boot) and this [one](https://www.baeldung.com/global-error-handler-in-a-spring-rest-api). 

If an `id` is not found, a custom exception called `NotFoundException` is thrown.
`GlobalControllerExceptionHandler` handles that kind of exception using `@ControllerAdvice.


### Use JWT tokens

Setup JWT token following this [article](https://www.javainuse.com/spring/boot-jwt)

## MVC HandlerInterceptor with Spring Boot

Setup HandlerInterceptor following this [article](https://www.javainuse.com/spring/bootInterceptor)


