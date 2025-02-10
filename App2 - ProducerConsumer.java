package com;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App2 {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue <Integer>(10);

	
	private static void producer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			queue.put(random.nextInt(100));
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			Thread.sleep(100);
			if (random.nextInt(10)==0) {
				Integer value = queue.take();
				System.out.println("Taken value: "+ value + " ; Queue size is " + queue.size());
			}
		
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try{
					producer();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try{
					consumer();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		/*
		 t1.join();
		 t2.join();
		
		 * Bisognerebbe aspettare che non finiscono, ecco perchè andrebbero inserite queste due istruzioni.
		 * nel nostro caso, didattico,  effettuiamo un kill del programma.
		
		 */
		/*
		 * L'esecuzione del programma evidenzia che il consumatore che preleva una volta su 10, quando estrae lo 0,
		 * mentre il produttore continua a generare. La queue accetta fino a un massimo di 10 valori.
		 * 
		 * Non ci dobbiamo preoccupare della sincrronizzazione, BlockingQueue è una struttura Thread-safe,
		 * possiamo accedere da Thread multipli.
		 * Non serve specificare synchronized perchè lo fa già la classe Concurrent.
		 * Se la coda è vuota si rimarrà in attesa che venga caricato un valore, 
		 * se invece è piena (massimo 10 elementi) rimane in attesa
		 */
		 
	}

}
