import java.util.concurrent.CountDownLatch;

class Service implements Runnable {
    private String name;
    private int delay;
    private CountDownLatch latch;

    public Service(String name, int delay, CountDownLatch latch) {
        this.name = name;
        this.delay = delay;
        this.latch = latch;
    }

    public void run() {
        try {
            System.out.println(name + " is starting...");
            Thread.sleep(delay); // Simula il tempo di avvio del servizio
            System.out.println(name + " is UP.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // Segnala che il servizio è pronto
        }
    }
}

public class SystemStartup {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Thread dbService = new Thread(new Service("Database Service", 4000, latch));
        Thread webService = new Thread(new Service("Web Server", 2000, latch));
        Thread cacheService = new Thread(new Service("Cache Service", 3000, latch));

        dbService.start();
        webService.start();
        cacheService.start();

        try {
            latch.await(); // Attende che tutti i servizi siano "UP"
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All services are up. Application is starting now...");
    }
}