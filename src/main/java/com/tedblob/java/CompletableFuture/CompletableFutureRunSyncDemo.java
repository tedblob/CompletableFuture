package com.mslc.trainings.reactive;


import java.util.concurrent.*;

public class CompletableFutureRunSyncDemo {


    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) {

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("runAsync executed in the thread: " +
                    Thread.currentThread().getName());
        });

        cf.join();
    }
}
