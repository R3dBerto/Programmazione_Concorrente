
class Campana implements Runnable {
    
    String suono;
    int volte;
    
    public Campana(String suono, int volte){
        this.suono = suono;
        this.volte = volte;
    }
    
    public void run() {
        for (int i=0; i<volte; i++){
            System.out.println((i+1) + suono);
        }
    }
}
public class Dindondan
{
   public static void main(String args[]){
       // prima modalità di definizione 
       Runnable camp1 = new Campana("din",5);
       Thread thr1 = new Thread(camp1);
       thr1.start();
       
       //seconda modalità i sefinizione
       Thread thr2 = new Thread(new Campana("don",5));
       thr2.start();
       
       //terza modalità di definizione
       new Thread(new Campana("dan",5)).start();
   }
}
