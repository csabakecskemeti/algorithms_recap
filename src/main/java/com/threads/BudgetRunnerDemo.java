package com.threads;

/**
 * Created by kecso on 7/6/17.
 */
public class BudgetRunnerDemo {
    public static void main(String[] args) {
        System.out.println("demo budget runner");
        Thread t = new Thread(new BudgetRunner());
        t.start();
        System.out.println(">>>>>>> interrupt");
        t.interrupt();
        System.out.println(">>>>>>> interrupt done");
        System.exit(0);
    }
}
