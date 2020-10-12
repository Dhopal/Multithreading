package lecture2;

import java.util.Scanner;

class Processor extends Thread{

    private volatile boolean running = true;
    //volatile guarantees that the value of running is not cached, and run can terminate

    public void run(){
        while(running) {
            System.out.println("Hello");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        running = false;
    }
}

public class demo1 {
    public static void main(String[] args) {
        Processor proc = new Processor();
        proc.start();

        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc.shutdown();
    }
}
