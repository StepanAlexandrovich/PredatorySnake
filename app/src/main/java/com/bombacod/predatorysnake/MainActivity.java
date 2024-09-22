package com.bombacod.predatorysnake;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends SurfaceView implements SurfaceHolder.Callback {
        private Engine engine;

        public DrawView(Context context) {
            super(context);
            getHolder().addCallback(this);

            setOnTouchListener((view, motionEvent) -> {

                float x = motionEvent.getX();
                //float y = motionEvent.getY();

                if(x < this.getWidth()/2){ engine.left();  }
                else                     { engine.right(); }

                return  false;
            });
        }

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            engine = new Engine(getHolder());
            engine.setRunning(true);
            engine.start();
        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int format, int width, int height) {
        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            boolean retry = false;
            engine.setRunning(false);
            while (retry){

                try {
                    engine.join();
                    retry = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}