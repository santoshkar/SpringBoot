package com.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 
 * @author skar
 *
 */
@Component
public class Receiver {
	
	@RabbitListener(queues=MessageConstants.QUEUE_NAME)
	public void processMessage(String message){
		System.out.println("\n\n\nMessage Received...");
		System.out.println("----------------------------------------------------------");
		System.out.println(message);
		System.out.println("----------------------------------------------------------\n\n\n");
	}
}
