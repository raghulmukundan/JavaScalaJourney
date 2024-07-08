package com.javascalajourney;

public class DaemonGracefulShutdown {

    private static class BackgroundTask implements Runnable {

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                System.out.println("Daemon thread running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Daemon thread stopped.");
        }

        public void stop() {
            running = false;
        }
    }

    public static void main(String[] args) {
        BackgroundTask task = new BackgroundTask();
        Thread daemonThread = new Thread(task);
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.stop(); // Signal the daemon thread to stop
        System.out.println("Main thread finished");
    }
}
