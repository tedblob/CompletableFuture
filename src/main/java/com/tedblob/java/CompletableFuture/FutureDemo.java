package com.tedblob.java.CompletableFuture;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        //exec.submit()
        Future<Integer> f = exec.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("Performing mathematical computation..");
                return 25;
            }
        });

        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Future<?> runnableFuture = exec.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing Runnable START");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Executing Runnable END");
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnableFuture.cancel(true);

    }

}
