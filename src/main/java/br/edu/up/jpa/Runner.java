package br.edu.up.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Runner implements CommandLineRunner {
	
	@Autowired
	private OrderQueueSender sender;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enviando mensagem ao RabbitMQ...");
		sender.send("Mensagem de conexão: Módulo VENDAS");
		
	}

}
