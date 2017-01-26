package com.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceWithRabbitMqApplication implements CommandLineRunner{

	@Autowired
	private Sender sender;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWithRabbitMqApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		sender.send("Hello... Welcome to Messaging system");
		sender.send("This is another message");
	}
	
	
}
