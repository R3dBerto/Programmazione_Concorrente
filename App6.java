package demo1;

public class App4 {
	private int count=0;
	
	/*
	public synchronized void increment() {
		count++;
	}
	*/
	/*
	public void increment() {
		count++;
	}
	*/
	
	public static void main(String[] args) {
		App4 app=new App4();
		app.doWork();

	}
	
	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i=0; i<10000; i++) {
					count++;
					//increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i=0; i<10000; i++) {
					count++;
					//increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		// inizio da commentare 
		/*
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		// fine da commentare 
		
		System.out.println("Count is: " + count);
		
	}

}
