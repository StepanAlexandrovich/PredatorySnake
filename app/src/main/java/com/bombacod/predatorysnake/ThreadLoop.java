package com.bombacod.predatorysnake;

public abstract class ThreadLoop extends Thread{
    private boolean running = false;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public abstract void process();

    @Override
    public void run() {
        while (running){
            process();
        }
    }

}
