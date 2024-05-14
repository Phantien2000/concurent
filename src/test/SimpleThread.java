package test;

import java.util.Random;

public class SimpleThread extends Thread {

    private int n = 0;

    public SimpleThread(int k) {
        this.n = k;
    }

    public void run() {
        System.out.println("Thread#" + n + " is running...");
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {}
        System.out.println("Thread#" + n + " has been done!");
    }
}