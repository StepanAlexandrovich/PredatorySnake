package com.bombacod.predatorysnake;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.visualization.Render;

public class LoopCanvas extends ThreadLoop{
    private SurfaceHolder surfaceHolder;

    private Model model;
    private Render render;

    public LoopCanvas(SurfaceHolder surfaceHolder, Model model) {
        this.surfaceHolder = surfaceHolder;

        this.model = model;
        this.render = new Render();
    }

    @Override
    public void process() {
        Canvas canvas = null;
        try{

            canvas = surfaceHolder.lockCanvas();
            if(canvas != null && model != null){
                render.draw(canvas,model);
            }

        }finally {
            if(canvas != null){
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

    }

}
