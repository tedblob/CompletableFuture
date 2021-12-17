package com.tedblob.java.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThenApply {
    public void main(String[] args) throws InterruptedException {

        CompletableFuture<Integer> numberCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("numberCompletableFuture executes in : " + Thread.currentThread().getName());
            return 5;
        });


        CompletableFuture<Integer> squareNumber = numberCompletableFuture.thenApply(number -> number * number);
        CompletableFuture<CompletableFuture<Integer>> squareNumberFuture = numberCompletableFuture.thenApply(number -> {

            System.out.println("thenCompose executes in : " + Thread.currentThread().getName() +
                    Thread.currentThread().isDaemon());
            return calculateSquare(number);

        });



        Thread.sleep(6000);
        /*try {
            System.out.println(squareNumberFuture.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }
    private CompletableFuture<Integer> calculateSquare(Integer number) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("squareNumberFuture executes in : " + Thread.currentThread().getName());
            return number * number;
        });
    }
}
