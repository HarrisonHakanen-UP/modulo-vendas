package br.edu.up.jpa;

import java.util.concurrent.CountDownLatch;

public class Receiver {
	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		System.out.println("Recebido <" + message + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
