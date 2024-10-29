package com.bombacod.predatorysnake;

public class SpeedMeasurement {
    private long distance;
    private long lastTime,nowTime;

    private int stepNow,stepLast;
    private int difference;

    public SpeedMeasurement(long distance) {
        this.distance = distance;
    }

    // get
    public int getDifference() {
        return difference;
    }
    public String getDifferenceText() {
        return "" + difference;
    }

    ////////////
    public void process(){
        stepNow++;
        nowTime = System.currentTimeMillis();
        if(stepNow == 1){ lastTime = nowTime; } // для идеального старта на практике необязательно

        if(nowTime - lastTime > distance){
            difference = stepNow - stepLast;

            lastTime = nowTime;
            stepLast = stepNow;
        }
    }

}
