package com.javascalajourney;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DaemonThreadPools {

    public static void main(String[] args) {
        ThreadFactory daemonThreadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2, daemonThreadFactory);

        Runnable task = () -> {
            while (true) {
                System.out.println("Daemon thread running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        executorService.execute(task);
        executorService.execute(task);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
        executorService.shutdown();
    }
}
