import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker{
    
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();
    
    
     private Object lock1 = new Object();
     private Object lock2 = new Object();
     
    
    public synchronized void stageOne(){
    /* 
     public void stageOne(){
        synchronized(lock1){
     */
    
        
        try
        {
            Thread.sleep(1);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        
        list1.add(random.nextInt(100));
    //}
        
    }
    
    public synchronized void stageTwo(){ 
    /* public void stageTwo(){
    
        synchronized(lock2){
     */
         try
        {
            Thread.sleep(1);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
    
        list2.add(random.nextInt(100));
    //}
        
    }
    
    /*public void process(){
        for(int i=0; i<1000; i++){
            stageOne();
            stageTwo();
        }
    }*/

    public void main(){
        System.out.println("Starting ...");
        
        long start = System.currentTimeMillis();
        //process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run(){
                //process();
                for(int i=0; i<1000; i++)
                    stageOne();
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run(){
                //process();
                for(int i=0; i<1000; i++)
                    stageTwo();
            }
        });
        
        t1.start();
        t2.start();
        
        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }  //aspetto che i thread terminano
        
        long end = System.currentTimeMillis();
        
        System.out.println(" Time take " + (end -start));
        System.out.println(" List1: " + list1.size() + " List2: " + list2.size() );
    }
}
