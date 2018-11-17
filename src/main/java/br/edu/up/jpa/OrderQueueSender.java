package br.edu.up.jpa;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderQueueSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queue;

	public void send(String venda) {
		rabbitTemplate.convertAndSend(this.queue.getName(), venda);
	}

}
