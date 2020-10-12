package lecture1;

class Runner1 implements Runnable{

    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("hello "  + i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class demo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner1());

        t1.start();
        t2.start();
    }
}
