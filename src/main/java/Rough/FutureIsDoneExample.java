package Rough;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

public class FutureIsDoneExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                return "Hello world";
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);

        System.out.println("Submitting callable");
        Future<String> future =  executor.submit(callable);



        while(future.isDone() == false){
            System.out.println("Future has not returned.");
            Thread.sleep(10);
        }

        System.out.println(future.get());
        System.out.println("Future has returned.");


        executor.shutdown();
    }
}
