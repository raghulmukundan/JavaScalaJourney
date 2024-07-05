package com.javascalajourney;

class RunnableThread implements Runnable {
    
    @Override
    public void run(){
        System.out.println("Runnable is running");
    }

    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread();
        Thread thread = new Thread(runnableThread);
        thread.start(); 
    }
}
