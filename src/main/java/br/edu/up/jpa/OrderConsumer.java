package br.edu.up.jpa;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

public class OrderConsumer {
	
	@RabbitListener(queues = { "${queue.order.name}" })
	public void receive(@Payload String venda) {
		System.out.println("Mensagem recebida: " + venda);
	}

}
