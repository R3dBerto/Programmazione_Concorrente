package com;

import java.util.Scanner;

public class Processor {
	public void produce() throws InterruptedException{
		
		synchronized(this) {
			System.out.println("Producer thread running...");
			wait();
			System.out.println("Resumed.");
		}
	}
	
	public void consume() throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized(this) {
			System.out.println("Waiting for return key...");
			scanner.nextLine();
			System.out.println("Return key pressed.");
			notify();
			
			//Thread.sleep(5000);
		}
	}

	
	/*
	 * synchronize richiede un oggetto su cui sincronizzarsi. In questo caso usiamo Processor che usa l'intrinsic lock
	 * non potrà eseguire run finchè non acquisisce il lock intrinsecodell'oggetto(processo).
	 * wait: ogni oggetto java ha un metodo wait, perchè è un metodo della classe object da cui discendono tutti gli oggetti
	 * Il blocco synchronized di produce() perde il controllo del blocco e attende per riaverlo. Verrà eseguitoper primo produce() 
	 * perchè il secondo metodo consume inizia con sleep(2000) che attende 2 sec. quando il primo blocco  trova wait() cede il controllo 
	 * consume agisce sullo stesso oggetto (this) cioè usa lo stresso intrinsic lock. notify() notifica al primo thread e dice a wait()
	 * di risvegliarsi, ma mantiene il controllo su questo lock.
	 * prova ad inserire ora Thread.sleep(5000);
	 */
}
