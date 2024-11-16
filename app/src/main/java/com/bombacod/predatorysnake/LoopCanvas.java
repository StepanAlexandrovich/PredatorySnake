package com.bombacod.predatorysnake;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.visualization.Render;
import com.bombacod.predatorysnake.visualization.buttons.Button;

public class LoopCanvas extends ThreadLoop{
    private SurfaceHolder surfaceHolder;

    private Model model;
    private Render render;

    public LoopCanvas(SurfaceHolder surfaceHolder, Model model) {
        this.surfaceHolder = surfaceHolder;

        this.model = model;
        this.render = new Render();
    }

    // encapsulation Render
    public Button getButtonLeft() { return render.getButtonLeft(); }
    public Button getButtonRight() { return render.getButtonRight(); }
    public Button getButtonRestart() { return render.getButtonRestart(); }

    @Override
    public void process() {
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
