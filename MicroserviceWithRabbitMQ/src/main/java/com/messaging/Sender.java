package com.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * 
 * @author skar
 *
 */
@Component
public class Sender {
	
	@Autowired
	private RabbitMessagingTemplate msgTemplate;
	
	@Bean
	private Queue queue(){
		return new Queue(MessageConstants.QUEUE_NAME, false);
	}
	
	public void send(String message){
		msgTemplate.convertAndSend(MessageConstants.QUEUE_NAME, message);
	}
}
