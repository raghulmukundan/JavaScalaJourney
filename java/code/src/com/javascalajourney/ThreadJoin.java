package com.javascalajourney;

public class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Thread running printing " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();
        try {
            thread.join(); // Main thread waits for this thread to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread continues after thread completion");

    }
}
