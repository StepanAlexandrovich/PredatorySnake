package com.bombacod.predatorysnake.threadhelpers;

public abstract class ThreadLoop extends Thread{
    private boolean loop = true;
    public void stopLoop(){
        loop = false;
    }
    public boolean isLoop() {
        return loop;
    }
}
