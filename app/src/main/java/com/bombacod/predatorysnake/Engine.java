package com.bombacod.predatorysnake;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.bombacod.predatorysnake.core.Model;

public class Engine extends Thread{
    private SurfaceHolder surfaceHolder;
    private boolean running = false;

    //////////////////////////////
    private Model model = new Model(101,101);
    private Render render = new Render(model);
    ////////////////////////////////

    public Engine(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        Canvas canvas;

        while (running){
            canvas = null;
            try{
                canvas = surfaceHolder.lockCanvas();
                if(canvas == null){ continue; }

                ////////////////////////////
                model.process();
                render.draw(canvas,model);
                ////////////////////////////

            }finally {
                if(canvas != null){
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
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
