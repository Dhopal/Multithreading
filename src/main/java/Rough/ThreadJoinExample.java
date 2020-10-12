package Rough;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Entered thread 1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Exited thread 1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Entered thread 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Exited thread 2");
            }
        });

        System.out.println("Starting thread 1");
        t1.start();

        System.out.println("Waiting for thread 1 to complete");

        try {
            t1.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waited enough for thread 1");
        System.out.println("Starting thread 2");

        t2.start();
    }
}
