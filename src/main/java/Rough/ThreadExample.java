package Rough;

public class ThreadExample extends Thread{
    public void run(){
        System.out.println("Inside thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Inside thread " + Thread.currentThread().getName());
        System.out.println("Creating Thread");
        Thread t = new ThreadExample();
        System.out.println("Starting thread " + t.getName());
        t.start();
    }
}
