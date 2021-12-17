package com.tedblob.java.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenCompose {
    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Integer> numberCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("numberCompletableFuture executes in : " + Thread.currentThread().getName());
            return 5;
        });


        CompletableFuture<Number> squareNumberFuture = numberCompletableFuture.thenCompose(number -> {

            System.out.println("thenCompose executes in : " + Thread.currentThread().getName() +
                    Thread.currentThread().isDaemon());

              return CompletableFuture.supplyAsync(() -> {
                  try {
                      Thread.sleep(5000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("squareNumberFuture executes in : " + Thread.currentThread().getName());
                  return number * number;
              });

        });

        Thread.sleep(6000);
        /*try {
            System.out.println(squareNumberFuture.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }
}
