import java.util.*;
import java.util.Scanner;

public class Aspettali implements Runnable
{
    String mioNome;
    int tempoDormi;
    
    Aspettali (String chiSono, int quanto){
        mioNome = chiSono;
        tempoDormi = quanto;
    }
    
    public void run() {
        try {
            System.out.println("il thread "+ mioNome + " ora si sospende");
            Thread.sleep(tempoDormi);
            System.out.println("il thread "+ mioNome + " si sveglia e termina");
        }catch(InterruptedException e){
            System.out.println(e);
        }
        return;
    }
    public static void main(String[] a){
        long start=0, stop=0, delta=0;
        int quanti = 5000;
        Thread thr1 = new Thread(new Aspettali("Ali", quanti));
        Thread thr2 = new Thread(new Aspettali("Baba", quanti));
        System.out.println("Ogni thread attende "+quanti+" millisecondi");
        //leggo il tempo prima di lanciare i thread
        start= System.currentTimeMillis();
        //avvio l'esecuzione dei thread
        thr1.start();
        thr2.start();
        try{
            thr1.join();
            thr2.join();
            System.out.println("Il main riprende l'elaborazione");
            //leggo il tempo alla fine dei thread
            stop= System.currentTimeMillis();
            
        }catch(InterruptedException e){
            System.out.println(e);
        }
        delta = stop - start;
        System.out.println("l'elaborazione e' durata: "+ delta +" millisecondi");
    }
}
