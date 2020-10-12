package lecture1;

class Runner extends Thread{
    public void run(){
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class demo1 {
    public static void main(String[] args) {
        Runner runner_1 = new Runner();
        runner_1.start();

        Runner runner_2 = new Runner();
        runner_2.start();
    }
}
