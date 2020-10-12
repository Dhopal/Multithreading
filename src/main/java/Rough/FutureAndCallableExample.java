package Rough;

import java.util.concurrent.*;

public class FutureAndCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("Entered callable.");
                Thread.sleep(4000);
                return "hello from callable";
            }
        };

        System.out.println("Submitting callable.");
        Future<String> future = executor.submit(callable);

        System.out.println("Do something else while callable is being executed.");

        System.out.println("Retrieve the result of callable");

        System.out.println(future.get());
        executor.shutdown();
    }
}
