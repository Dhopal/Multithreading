package lecture8;

import java.util.Scanner;

public class Processor {
    public void producer() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread running.");
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consumer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        System.out.println("Press return to continue.");
        scanner.nextLine();

        synchronized (this){
            System.out.println("Consumer thread running.");
            notify();
            Thread.sleep(3000);
            System.out.println("again inside consumer");
        }
    }
}
