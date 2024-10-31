package com.bombacod.predatorysnake;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.bombacod.predatorysnake.core.Model;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends SurfaceView implements SurfaceHolder.Callback {
        private Model model;
        private LoopModel loopModel;
        private LoopCanvas loopCanvas;

        public DrawView(Context context) {
            super(context);
            getHolder().addCallback(this);

            setOnTouchListener((view, motionEvent) -> {

                float x = motionEvent.getX();
                //float y = motionEvent.getY();

                if(x < this.getWidth()/2){ model.left();  }
                else                     { model.right(); }

                return  false;
            });
        }

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            model = new Model(101,101);
            loopModel = new LoopModel(model,50);
            loopCanvas = new LoopCanvas(surfaceHolder,model);

            loopCanvas.setRunning(true);
            loopModel.setRunning(true);

            loopCanvas.start();
            loopModel.start();
        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int format, int width, int height) {
        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            boolean retry = true;
            loopModel.setRunning(false);
            loopCanvas.setRunning(false);
            while (retry){

                try {
                    loopModel.join();
                    loopCanvas.join();

                    retry = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}