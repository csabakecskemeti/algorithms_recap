package com.threads;

import java.util.Timer;

/**
 * Created by kecso on 7/6/17.
 */
public class BudgetRunner implements Runnable {

    @Override
    public void run() {
        long start = System.nanoTime();
        System.out.println(Thread.currentThread().isInterrupted());
        int i = 10;
        while (!Thread.currentThread().isInterrupted() && i > 0) {
            try {
                System.out.println("start running");
                Thread.sleep(2);
                i--;
                System.out.println("runtime: " + (System.nanoTime() - start) + " " + i);
                System.out.println(Thread.currentThread().isInterrupted());
            } catch (InterruptedException ex) {
                System.out.println("Interrupted runtime: " + (System.nanoTime() - start));
                Thread.currentThread().interrupt();
            }

        }
    }
}
