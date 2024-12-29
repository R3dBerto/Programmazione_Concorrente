
/**
 * Thread implementando Runnable
 * 
 * @author Roberto
 * @version 27/12/2024
 */

class Runner implements Runnable {
        public void run(){
            for ( int i=0; i<10; i++){
                System.out.println("Hello" + i);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        
    }
public class App
{
   public static void main (String[] args){
       Thread t1 = new Thread(new Runner());
       Thread t2 = new Thread(new Runner());

       //metodo abbreviato che usa una classe anonima
       Thread t3 = new Thread(new Runnable() {
        @Override
        public void run(){
            for (int i=0; i<10; i++){
                System.out.println("ciao " + i);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
       });
       
       t1.start();
       t2.start();
       t3.start();
       
   }

}
