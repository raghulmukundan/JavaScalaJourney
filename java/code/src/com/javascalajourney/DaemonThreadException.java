package com.javascalajourney;

public class DaemonThreadException {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Daemon thread running");
                    Thread.sleep(1000);
                    throw new RuntimeException("unexpected error");
                }
            } catch (InterruptedException e) {
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Exception in " + t.getName() + ": " + e.getMessage());
        });
        daemonThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }
}
