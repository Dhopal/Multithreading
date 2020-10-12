package lecture12;

import java.util.concurrent.Semaphore;

//singleton class
public class Connection {
    private static Connection instance = new Connection();

    private int connections = 0;
    private Semaphore sem = new Semaphore(10);

    private Connection(){}

    public static Connection getInstance(){
        return instance;
    }

    public void connect(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            doConnect();
        } finally {
            sem.release();
        }
    }
    public void doConnect(){
        synchronized (this) {
            connections++;
            System.out.println("Current Connections = " + connections);
        }
        try {
                Thread.sleep(2000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        synchronized (this) {
            connections--;
        }
    }
}
