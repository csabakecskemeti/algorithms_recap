package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by kecso on 2/14/18.
 */
class Dummy {
    int x = 8;

    public synchronized void lock() throws InterruptedException {
        System.out.println("lock");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("unlock");
    }

    public synchronized void printX() {
        System.out.println(x);
    }
}

class MyThread extends Thread {
    Dummy d;

    public MyThread(Dummy d) {
        this.d = d;
    }
    public void run(){
        System.out.println("MyThread running");
        d.printX();
    }
}

class MyThread2 extends Thread {
    Dummy d;

    public MyThread2(Dummy d) {
        this.d = d;
    }
    public void run() {
        System.out.println("MyThread2 running");
        try {
            d.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("demo sync");
        Dummy d = new Dummy();

        MyThread t1 = new MyThread(d);
        MyThread2 t2 = new MyThread2(d);
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t1.start();
    }
}
