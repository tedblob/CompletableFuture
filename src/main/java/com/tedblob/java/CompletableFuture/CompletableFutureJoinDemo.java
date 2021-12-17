package com.tedblob.java.CompletableFuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureJoinDemo {


    /**
     * @param args
     */
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Interrupting...");
            mainThread.interrupt();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Not Interrupted...");
            System.out.println("supplyAsync executed in the thread: " +
                    Thread.currentThread().getName());
            return "SUCCESS";
        });

        System.out.println(cf.join());

    }
}
