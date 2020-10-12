package lecture13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class SaurabhList{
    private List<Integer> saurabhList;
    public SaurabhList(List<Integer> l){
        saurabhList = l;
    }
    public List<Integer> getSaurabhList(){
        return saurabhList;
    }
}

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future< SaurabhList > future =  executor.submit(new Callable<SaurabhList>() {

            public SaurabhList call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                System.out.println("Starting...");

                Thread.sleep(duration);

                System.out.println("Finished.");

                List<Integer> l = new ArrayList<Integer>();
                l.add(random.nextInt());
                l.add(random.nextInt());
                l.add(random.nextInt());

                SaurabhList s = new SaurabhList(l);

                return s;
            }
        });

        executor.shutdown();
        System.out.println(future.get().getSaurabhList());

    }
}
