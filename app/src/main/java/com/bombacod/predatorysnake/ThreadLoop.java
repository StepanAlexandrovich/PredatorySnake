package com.bombacod.predatorysnake;

public abstract class ThreadLoop extends Thread{
    private boolean running = true;
    public void stopRun(){
        running = false;
    }
    public boolean isRunning() {
        return running;
    }
}
