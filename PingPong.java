package PP;

class Racchetta implements Runnable{
	String pallina;
	public Racchetta(String pallina) {
		this.pallina = pallina;	
	}
	public void run() {
		while (true) {
			System.out.println(pallina);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//cede l'esecuzione ad un altro thread
			Thread.yield();
		}
	}
}

public class PingPong {

	public static void main(String[] args) {
		// primo giocatore
		Thread thr1 = new Thread(new Racchetta("ping"));
		thr1.start();
		
		//secondo giocatore
		Thread thr2 = new Thread(new Racchetta("pong"));
		thr2.start();

	}

}
