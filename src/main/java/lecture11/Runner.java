package lecture11;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock firstLock, Lock secondLock) {
        while(true){
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try{
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            } finally {
                if(gotFirstLock == true && gotSecondLock == true){
                    return;
                }
                if(gotFirstLock == true){
                    firstLock.unlock();
                }
                if(gotSecondLock == true){
                    secondLock.unlock();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread(){
        Random random = new Random();

        for(int i = 0; i < 10000; i++){
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread(){
        Random random = new Random();

        for(int i = 0; i < 10000; i++){
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished(){
        System.out.println("Account 1 balance is : " + acc1.getBalance());
        System.out.println("Account 2 balance is : " + acc2.getBalance());
        System.out.println("Total balance is : " + (acc1.getBalance() + acc2.getBalance()));
    }
}
