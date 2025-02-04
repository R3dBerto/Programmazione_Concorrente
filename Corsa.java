import java.io.*;
import java.util.*;

class Nipote extends Thread{
    static boolean finita=false;
    private String nome;
    private int percorso=0;
    private int avanza, riposa;
    
    public Nipote(String nome){
        super();
        this.nome=nome;
        System.out.println("=> parte " + nome);
    }
        
    public void run(){
        while (finita==false){
        try {
            Random casuale = new Random();
            avanza = casuale.nextInt(20);
            percorso = percorso + avanza;
            System.out.println(nome + " ha percorso " + percorso);
            if (percorso<100){
                System.out.println(" Non ho finito, miriposo un attimo ");
                riposa = casuale.nextInt(20);
                Thread.sleep(riposa); //introduce un ritardo
            }else {
                this.finita=true;
                System.out.println(nome + " ha preso la merenda!!! ");
            }
        }catch (InterruptedException e){}
        
        Thread.yield(); //cede l'esecuzione a un altro thread
                
        }
            
    }
}

public class Corsa
{

    public static void main(String[] args) {
        
        Thread thr1= new Nipote("Qui");
        Thread thr2= new Nipote("Quo");
        Thread thr3= new Nipote("Qua");
        thr1.start();
        thr2.start();  
        thr3.start();
        
    }
}