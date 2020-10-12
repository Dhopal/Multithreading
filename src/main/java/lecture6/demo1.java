package lecture6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Worker implements  Runnable{
    private int id;
    private CountDownLatch latch;

    public Worker(int id, CountDownLatch latch){
        this.id = id;
        this.latch = latch;
    }

    public void run() {
        System.out.println("Starting..." + id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed..." + id);
        latch.countDown();
    }
}

public class demo1 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor =  Executors.newFixedThreadPool(2);
        for(int i = 0; i < 3; i++){
            executor.submit(new Worker(i, latch));
        }
        try {
            latch.await(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed.");
    }
}
