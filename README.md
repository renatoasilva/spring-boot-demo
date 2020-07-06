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

## Use Apache Kafka

Use Apache Kafka following this [article](https://www.javainuse.com/spring/spring-boot-apache-kafka-hello-world).
Kafka is set up following this [article](https://www.javainuse.com/misc/apache-kafka-hello-world) and this [one](https://medium.com/@Ankitthakur/apache-kafka-installation-on-mac-using-homebrew-a367cdefd273)

This Kafka installation comes with an inbuilt zookeeper. Zookeeper is mainly used to track status of nodes present in Kafka cluster and also to keep track of Kafka topics, messages, etc.

Start zookeeper
> zkServer start

or

> zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

Start kafka:
> kafka-server-start /usr/local/etc/kafka/server.properties

Or both:
> zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties

WARNING:

During server start, you might be facing connection broken issue.

> [2018-08-28 16:24:41,166] WARN [Controller id=0, targetBrokerId=0] Connection to node 0 could not be established. Broker may not be available. (org.apache.kafka.clients.NetworkClient)
> [2018-08-28 16:24:41,268] WARN [Controller id=0, targetBrokerId=0] Connection to node 0 could not be established. Broker may not be available. (org.apache.kafka.clients.NetworkClient)

To fix this issue, we need to change the server.properties file.

> vim /usr/local/etc/kafka/server.properties

Here uncomment the server settings and update the value from

> listeners=PLAINTEXT://:9092

to

> listeners=PLAINTEXT://localhost:9092

and restart the server and it will work great.

## Initialize Producer console:

Now we will initialize the Kafka producer console, which will listen to localhost at port 9092 at topic test :
> kafka-console-producer --broker-list localhost:9092 --topic test

Create a topic
> kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic javainuse-topic

Start a consumer, listening to topic "java_in_use_topic":
> kafka-console-consumer --bootstrap-server localhost:9092 --topic java_in_use_topic --from-beginning

Send a message to kafka
> curl -H 'Accept: application/json' -H "Authorization: Bearer ${TOKEN}" http://localhost:8080/javainuse-kafka/producer?message=sendfromCLI