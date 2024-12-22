package com.bombacod.predatorysnake.timing;

import com.bombacod.predatorysnake.timing.SimpleTimer;

public class SpeedMeasurement {
    private int step,speed;

    private SimpleTimer simpleTimer;

    public SpeedMeasurement(long distance) {
        simpleTimer = new SimpleTimer(distance);
    }

    public void reset(){
        step = 0;
        simpleTimer.reset();
    }

    // get
    public int getSpeed() {
        return speed;
    }
    public String getSpeedText() {
        return "" + speed;
    }

    ////////////
    public int process(){
        step++;

        if(simpleTimer.process()){
            speed = step;
            step = 0;
        }

        return speed;
    }

}
