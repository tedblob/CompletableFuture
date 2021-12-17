package com.tedblob.java.CompletableFuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSupplyAsyncDemo {


    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("supplyAsync executed in the thread: " +
                    Thread.currentThread().getName());
            return "SUCCESS";
        });
        cf.whenComplete((result, throwable) ->
        {
            if (throwable == null) {
                System.out.println("whenComplete : "
                        + result
                        + " in thread. " + Thread.currentThread().getName());
            }
        });
        Thread.sleep(10000);

    }
}
