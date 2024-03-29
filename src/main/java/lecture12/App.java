package lecture12;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        //Semaphore sem = new Semaphore(1);

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 200; i++){
            executor.submit(new Runnable() {
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
