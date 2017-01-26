#Workign on AMPQ
This application is not a Spring MVC app. This is the messaging application and using AMPQ. In dependency, choose I/O -> AMPQ.

Before working on this application, make sure the RabbitMQ is already installed and the server is already started.

application.properties
-----------------------
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest



