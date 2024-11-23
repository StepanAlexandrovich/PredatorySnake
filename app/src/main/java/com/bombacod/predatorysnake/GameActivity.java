package com.bombacod.predatorysnake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.pf.IntentKeyWords;

public class GameActivity extends AppCompatActivity {
    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawView = new DrawView(this);
        setContentView(drawView);
    }

    class DrawView extends SurfaceView implements SurfaceHolder.Callback {
        private Model model;
        private LoopModel loopModel;
        private LoopCanvas loopCanvas;

        public DrawView(Context context) {
            super(context);
            getHolder().addCallback(this);

            setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();

                    loopCanvas.getButtonLeft().process(x,y,() -> model.left());
                    loopCanvas.getButtonRight().process(x,y,() -> model.right());
                    loopCanvas.getButtonRestart().process(x,y,() -> model.restart());

                    return false;
                }
            });

        }

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {

            int levelIndex = (int)getIntent().getSerializableExtra(IntentKeyWords.LEVEL_INDEX);
            model = new Model(111,91).setLevelIndex(levelIndex);
            loopModel = new LoopModel(model,15);
            loopCanvas = new LoopCanvas(surfaceHolder,model);

            loopCanvas.setRunning(true);
            loopModel.setRunning(true);

            loopCanvas.start();
            loopModel.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
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

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(IntentKeyWords.LEVEL_DTO, new LevelDto(drawView.model.getLevelIndex(),drawView.model.getGameState()));

            startActivity(intent);
            finish();
        }catch (Exception e){

        }

    }

 }
