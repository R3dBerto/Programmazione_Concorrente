
class Runner2 extends Thread {
	@Override 
	public void run() {
		String nomeThreadRun = Thread.currentThread().getName();
		System.out.println(nomeThreadRun);
		for (int i=0; i<10; i++) {
			System.out.println("Hello " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

public class App2{

	public static void main(String[] args) {
		String nomeThreadMain = Thread.currentThread().getName();
		System.out.println(nomeThreadMain);
		
		Runner2 runner1 = new Runner2();
		runner1.start();

		//Runner2 runner2 = new Runner2();
		//runner2.start();

	}
	
	

}
