package com.javascalajourney;

public class DaemonThreadBasic {

    public static void main(String[] args) {

        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }
}
