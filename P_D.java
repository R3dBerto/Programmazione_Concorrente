
class PariDispari extends Thread{
    int max;
    boolean pari;
    public PariDispari(int max, boolean pari){
        super();
        this.max=max;
        this.pari=pari;
    }
        
    public void run(){
        for (int x=0; x<max; x++){
            if(pari){
                if(x%2 ==0)
                    System.out.println("Pari -> " +x);
            }else{
                if(x%2 !=0)
                    System.out.println("Dispari -> " +x);
                }
            try {
		 //Thread.sleep(1);
		 Thread.sleep(10);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
            
    }
}
}

public class P_D
{

    public static void main(String[] args) {
        int n=20;
        Thread tP= new PariDispari(n,true);
        Thread tD= new PariDispari(n,false);
        tP.start();
        tD.start();
    }
}
			


