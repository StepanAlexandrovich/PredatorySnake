package com.bombacod.predatorysnake;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.visualization.Render;

public class LoopCanvas extends Thread{
    private SurfaceHolder surfaceHolder;
    private boolean running = false;

    //////////////////////////////
    private Model model;
    private Render render;
    ////////////////////////////////

    public void drawing(Model model) {
        this.model = model; // переделать
    }

    public LoopCanvas(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;

        render = new Render();
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
                if(model != null){
                    render.draw(canvas,model);
                }
                ////////////////////////////

            }finally {
                if(canvas != null){
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

}
