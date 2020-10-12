package Rough;

public class RunnableExample implements Runnable{
    public static void main(String[] args) {
        System.out.println("Creating thread using runnable");
        RunnableExample runnableExample = new RunnableExample();
        Thread t = new Thread(runnableExample);
        System.out.println("Thread created - " + t.getName());
        t.start();
    }


    public void run(){
        System.out.println("Inside thread " + ThreadExample.currentThread().getName());
    }
}
