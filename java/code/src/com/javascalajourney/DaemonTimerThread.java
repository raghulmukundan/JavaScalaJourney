package com.javascalajourney;

import java.util.Timer;
import java.util.TimerTask;

public class DaemonTimerThread {

    public static void main(String[] args) {
        //Create a Timer with a daemon thread
        Timer timer = new Timer(true); //true means the timer's thread is a daemon

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Scheduled task running ...");
            }
        };

        timer.scheduleAtFixedRate(task, 0, 2000);

        try {
            Thread.sleep(10000); //Main thread runs for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished");
    }
}
