package lecture3;


public class demo2 {
    private  int count = 0;

    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {
        demo2 app = new demo2();
        app.doWork();
    }
    public void doWork() {
        System.out.println("fuck");
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("count = " + count); // < 20000
    }
}
