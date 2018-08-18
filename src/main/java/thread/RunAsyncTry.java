package thread;

import java.util.concurrent.CompletableFuture;

public class RunAsyncTry {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("try CompletableFuture.runAsync(() -> {");
        run();
        Thread.sleep(12000);
    }
 
    private static void run() {
        CompletableFuture.runAsync(() -> {
            try {
                asyncRun();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("run - done");
        return;
    }
    
    private static void asyncRun() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}
