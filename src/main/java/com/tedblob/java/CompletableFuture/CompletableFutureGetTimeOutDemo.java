package com.tedblob.java.CompletableFuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureGetTimeOutDemo {


    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("supplyAsync executed in the thread: " +
                    Thread.currentThread().getName() + Thread.currentThread().isDaemon());
            return "SUCCESS";
        });
        try {
            System.out.println(cf.get(1000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            ex.printStackTrace();
        }

    }
}
