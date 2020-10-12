package lecture3;


public class demo1 {
    private int count = 0;
    public static void main(String[] args) {
        demo1 app = new demo1();
        app.doWork();
    }
    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++){
                    count++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++){
                    count++;
                }
            }
        });

        t1.start();
        t2.start();

        System.out.println("count = " + count); // < 20000

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("count = " + count); // < 20000
    }
}
