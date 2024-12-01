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
import com.bombacod.predatorysnake.pf.GameState;
import com.bombacod.predatorysnake.pf.IntentKeyWords;
import com.bombacod.predatorysnake.pf.StartupDownloads;
import com.bombacod.predatorysnake.visualization.Render;

public class GameActivity extends AppCompatActivity {
    private DrawView drawView;

    private ThreadLoop loopModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loopModel = new LoopModel(StartupDownloads.model,15);

        drawView = new DrawView(this);
        setContentView(drawView);
    }

    class DrawView extends SurfaceView implements SurfaceHolder.Callback {
        private Model model;
        private Render render;
        private ThreadLoop loopCanvas;

        public DrawView(Context context) {
            super(context);
            getHolder().addCallback(this);
        }

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            int levelIndex = (int)getIntent().getSerializableExtra(IntentKeyWords.LEVEL_INDEX);  // поизучать
            model = StartupDownloads.model.setLevelIndex(levelIndex);
            render = StartupDownloads.render;

            loopModel = new ThreadLoop(){
                private LoopCanvas loopCanvas = new LoopCanvas(surfaceHolder,model,render); // in StartDown
                private SimpleTimer timer = new SimpleTimer(15);  // distance in pl // in startDown
                @Override
                public void run() {
                    loopCanvas.start();

                    while (isRunning()){
                        if(timer.process()){ // fps
                            model.process();

                            if(model.getGameState() == GameState.WINNING){

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                stopRun();

                            }else
                            if(model.getGameState() == GameState.DEFEAT){

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }

                                model.setGameState(GameState.WAITING);
                            }
                        }
                    }

                    stopThreadLoop(loopCanvas);

                    back();
                }
            };

            setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();

                    render.getButtonLeft().process(x,y,() -> model.left());
                    render.getButtonRight().process(x,y,() -> model.right());
                    render.getButtonRestart().process(x,y,() -> model.restart());

                    return false;
                }
            });

            ///////////////////////////
            loopModel.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            stopThreadLoop(loopModel);
        }

    }

    // вынести
    private void stopThreadLoop(ThreadLoop threadLoop){
        boolean retry = true;

        while (retry){
            threadLoop.stopRun();

            try {
                threadLoop.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void back(){
        try {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(IntentKeyWords.LEVEL_DTO, new LevelDto(drawView.model.getLevelIndex(),drawView.model.getGameState()));

            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }

    @Override
    public void onBackPressed() {
        loopModel.stopRun();
    }

 }
