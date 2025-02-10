package com;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run() {
		System.out.println("Started...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();
	}
}

public class App {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor= Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed.");
	}
	
}
/*
 * abbiamo visto che ci si può imbattere in un sacco di terribili problemi con la sincronizzazione di thread,
 * ad esempio semplicemente per accedere ad un intero.
 * Fortunatamente esistono classi che sono Thread-safe, cioè permettono un accesso sicuro da thread differenti,
 * senza doverci preoccupare della sincronizzazione.
 * Questo esercizio utilizza CountDownLatch, permette di aspettare fino a che il contatore non raggiunge lo 0.
 * Uno o più Thread decrementano il contatore, e i thread in attesa possono procedere.
 * Per creare i thread viene usato un Executor che attiva 3 Thread ogniuno dei quali esegue processor.
 * processor in questo caso fa un conto alla rovescia sempre partendo da tre.
 * Nel main latch.await() aspetta finchè il conteggio non raggiunge lo 0
 * 
 * L'esecuzione evidenzia che i thread iniziano e ogniuno chiama il conto alla rovescia e attende tre secondi,
 * quando raggiunge lo 0 restituisce completed
	 */
