package lecture10;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private  int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment(){
        for(int i = 0; i < 10000; i++){
            count++;
        }
    }
    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting...");
        cond.await();
        System.out.println("Woken up!!!");
        try{
            increment();
        }
        finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        lock.lock();
        Thread.sleep(1000);

        System.out.println("Press return key to continue.");
        new Scanner(System.in).nextLine();
        System.out.println("Return key pressed.");
        cond.signal();

        try{
            System.out.println("increment second");
            increment();
        }
        finally {
            lock.unlock();
        }
    }

    public void finished(){
        System.out.println("Count = " + count);
    }
}
