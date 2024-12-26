package demo1;

class Runner3 extends Thread {
	public Runner3(String nome) {
		super();
		setName(nome);
	}
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(getName()+ " - " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

public class App3 {

	public static void main(String[] args) {
		/*String nomeThreadMain = Thread.currentThread().getName();
		System.out.println(nomeThreadMain);*/
		
		Runner3 runner = new Runner3("thread 1");
		runner.start();

		/*Runner3 runner2 = new Runner3("thread 2");
		runner2.start();*/

	}
	
	

}