package com.bombacod.predatorysnake;

public class SimpleTimer {
    private long distance;
    private long lastTime,nowTime;

    private int step = 0,stepHit = 0;
    private boolean hit = false;

    public SimpleTimer(long distance) {
        this.distance = distance;
    }

    public void reset(){
        step = 0;
        stepHit = 0;
    }

    // get
    public boolean isHit() { return hit; }
    public int getStep() { return step; }
    public int getStepHit() { return stepHit; }

    public String getStepHitText() { return "" + stepHit; }

    public boolean process(){
        step++;

        nowTime = System.currentTimeMillis();
        if(step == 1){ lastTime = nowTime; }

        if(nowTime - lastTime > distance){
            lastTime += distance;
            stepHit++;
            hit = true;
        }else{
            hit = false;
        }

        return hit;
    }
}
