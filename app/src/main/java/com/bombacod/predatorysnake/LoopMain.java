package com.bombacod.predatorysnake;

import android.view.SurfaceHolder;
import com.bombacod.predatorysnake.core.Model;

public class LoopMain extends Thread{
    private boolean running = false;

    //////////////////////////////
    private Model model;
    private SimpleTimer timer;
    ////////////////////////////////

    private LoopCanvas loopCanvas;

    public LoopMain(SurfaceHolder surfaceHolder) {
        model = new Model(101,101);
        timer = new SimpleTimer(50);

        loopCanvas = new LoopCanvas(surfaceHolder);
        loopCanvas.setRunning(true);
        loopCanvas.start();
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running){
            if(timer.process()){ // fps
                model.process();
            }

            loopCanvas.drawing(model);
        }

        //////////////// close stream Loop Canvas /////////////////
        boolean retry = true;
        loopCanvas.setRunning(false);
        while (retry){

            try {
                loopCanvas.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void left(){
        model.left();
    }
    public void right(){
        model.right();
    }

}
