package com.tedblob.java.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAllOfSuccessCase {
    public static void main(String[] args) throws InterruptedException {

        // first CompletableFuture
        CompletableFuture<Boolean> validateNewUser = CompletableFuture.supplyAsync(() -> {
            try {
                // validate new user details
                // inducing sleep for demo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return true;
        });
        // first CompletableFuture
        CompletableFuture<Boolean> registerNewUser = CompletableFuture.supplyAsync(() -> {
            try {
                // perform registration
                // inducing sleep for demo purpose
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Registration of new user : success");
            return true;
        });



        CompletableFuture<Void> finalCompletableFuture = CompletableFuture.allOf(validateNewUser,
                registerNewUser);
        /*finalCompletableFuture.whenComplete((result, throwable) -> {
            System.out.println("Result :" + result);
            System.out.println("Throwable : " + throwable);
        });*/

        Thread.sleep(5000);
    }
}
