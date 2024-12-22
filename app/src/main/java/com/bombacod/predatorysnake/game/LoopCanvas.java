package com.bombacod.predatorysnake.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.bombacod.predatorysnake.threadhelpers.ThreadLoop;
import com.bombacod.predatorysnake.game.core.Model;
import com.bombacod.predatorysnake.game.visualization.top.Render;

public class LoopCanvas extends ThreadLoop {
    private SurfaceHolder surfaceHolder;

    private Model model;
    private Render render;

    public LoopCanvas(SurfaceHolder surfaceHolder, Model model,Render render) {
        this.surfaceHolder = surfaceHolder;

        this.model = model;
        this.render = render;
    }

    @Override
    public void run() {
        while (isLoop()){
            Canvas canvas = null;
            try{

                canvas = surfaceHolder.lockCanvas();
                if(canvas != null && model != null){
                    render.draw(model,canvas);
                }

            }finally {
                if(canvas != null){
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

}
