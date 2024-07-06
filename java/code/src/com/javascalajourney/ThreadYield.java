package com.javascalajourney;

public class ThreadYield implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " running " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ThreadYield threadYield = new ThreadYield();
        Thread thread1 = new Thread(threadYield);
        Thread thread2 = new Thread(threadYield);
        thread1.start();
        thread2.start();
    }
}
