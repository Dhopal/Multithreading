package lecture7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class demo1 {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    private static void producer() throws InterruptedException {
        Random random = new Random();
        while(true){
            queue.put(random.nextInt(100));
        }
    }


    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while(true){
            Thread.sleep(100);
            Integer value = random.nextInt(10);
            if(value == 0){
                queue.take();
                System.out.println("Taken value = " + value + " Queue size = " + queue.size());
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }

}
