package com.javascalajourney;

class SimpleThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        SimpleThread thread = new SimpleThread();
        thread.start(); // Starts the thread, which invokes the run() method
    }
}
