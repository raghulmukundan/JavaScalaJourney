package com.javascalajourney;

public class ThreadSleep implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread running: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadSleep threadSleep = new ThreadSleep();
        Thread thread = new Thread(threadSleep);
        thread.start();
    }
}
