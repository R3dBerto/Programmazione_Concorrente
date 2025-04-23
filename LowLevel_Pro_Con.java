import java.util.LinkedList;
import java.util.Random;

public class LowLevel_Pro_Con {
    
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();
    
    public void produce() throws InterruptedException{
        
        int value=0;
        while (true) {
            synchronized (lock){
                
                while(list.size() == LIMIT){ //se la lista è piena sleep
                    lock.wait();
                }
                list.add(value++);
                lock.notify(); //risveglia informando che un item è inserito
            }
        }
        
    }
    
    public void consume() throws InterruptedException{
        
        Random random = new Random();
        
        while (true) {
            synchronized (lock){
                
                while(list.size() == 0){ //se la lista è vuota sleep
                    lock.wait();
                }
                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();  //preleva l'item
                System.out.println("; value is : " + value);
                lock.notify();        //risveglia il wait dopo aver prelevato
            }
            
            Thread.sleep(random.nextInt(1000));
        
        }
        
    }
    


    public static void main(String[] args) throws InterruptedException {
        final Processor processor = new Processor();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    processor.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    processor.consume();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
        //t1.join();
        //t2.join();
        
    }
}


