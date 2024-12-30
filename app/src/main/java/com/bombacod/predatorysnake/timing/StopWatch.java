package com.bombacod.predatorysnake.timing;

public class StopWatch {
    private long startTime;

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public long getTime(){
        return System.currentTimeMillis() - startTime;
    }
}
