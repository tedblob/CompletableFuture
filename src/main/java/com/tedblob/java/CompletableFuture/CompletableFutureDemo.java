package com.tedblob.java.CompletableFuture;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> {
                System.out.println("Performing mathematical computation.. 5 ");
                return 5;
        }).thenApply(number -> {
            System.out.println("Result of completable future: " + number);
            return number * number;
        }).thenApply(square -> {

            System.out.println("Result of completable future: " + square);
            return square*2;
        }).whenComplete((doubleNumber, throwable) -> {
            System.out.println("Result of completable future: " + doubleNumber);
        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
