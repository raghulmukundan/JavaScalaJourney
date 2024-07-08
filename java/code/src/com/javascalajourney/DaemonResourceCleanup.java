package com.javascalajourney;

public class DaemonResourceCleanup {

    private static class Resource {

        private boolean inUse;
        private String data; //Could be any object. Simplyfing it to string.

        public synchronized void use(String dataToUse) {
            inUse = true;
            data = dataToUse;
            System.out.println(Thread.currentThread().getName() + " - Resource in use.");
        }

        public synchronized void release() {
            inUse = false;
            data = null;
            System.out.println(Thread.currentThread().getName() + " - Resource released.");
        }

        public synchronized boolean inUse() {
            return inUse;
        }
    }

    private static class ResourceManager {

        private final Resource resource = new Resource();

        public void startUsingResource(String dataToUse) {
            new Thread(() -> {
                synchronized (resource) {
                    System.out.println(Thread.currentThread().getName() + " starting resource use");
                    resource.use(dataToUse);
                    try {
                        Thread.sleep(3000); //simulate resource usage
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(Thread.currentThread().getName() + " releasing resource after 3 seconds");
                        resource.release();
                    }
                }
            }).start();
        }

        public void startCleanupDaemon() {
            Thread cleanupThread = new Thread(() -> {
                while (true) {
                    synchronized (resource) {
                        if (!resource.inUse()) {
                            System.out.println("Performing resource cleanup...");
                        }

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            cleanupThread.setDaemon(true);
            cleanupThread.start();
        }

        public static void main(String[] args) {
            ResourceManager resourceManager = new ResourceManager();
            resourceManager.startCleanupDaemon();
            resourceManager.startUsingResource("First Thread Data");
            resourceManager.startUsingResource("Second Thread Data");

            try {
                Thread.sleep(10000); // Main thread runs for a while to let daemon thread work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Main thread finished");
        }
    }
}
