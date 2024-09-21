package com.bombacod.predatorysnake;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class Engine extends Thread{
    private SurfaceHolder surfaceHolder;
    private boolean running = false;

    //////////////////////////////
    private Model model = new Model();
    private Render render = new Render();
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
}
