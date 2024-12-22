package com.bombacod.predatorysnake.threadhelpers;

public class StopThreadLoop {
    public static void stopOneThread(ThreadLoop threadLoop){
        boolean retry = true;

        while (retry){
            threadLoop.stopLoop();

            try {
                threadLoop.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
