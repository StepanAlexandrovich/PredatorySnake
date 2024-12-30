package com.bombacod.predatorysnake.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.bombacod.predatorysnake.timing.SimpleTimer;
import com.bombacod.predatorysnake.threadhelpers.Sleeping;
import com.bombacod.predatorysnake.threadhelpers.StopThreadLoop;
import com.bombacod.predatorysnake.threadhelpers.ThreadLoop;
import com.bombacod.predatorysnake.levels.LevelDto;
import com.bombacod.predatorysnake.levels.LevelsActivity;
import com.bombacod.predatorysnake.DialogYesNo;
import com.bombacod.predatorysnake.game.core.Model;
import com.bombacod.predatorysnake.pf.GameState;
import com.bombacod.predatorysnake.pf.IntentKeyWords;
import com.bombacod.predatorysnake.pf.StartupDownloads;
import com.bombacod.predatorysnake.game.visualization.top.Render;

public class GameActivity extends AppCompatActivity {
    private DrawView drawView;
    private ThreadLoop loopMain;
    private LoopCanvas loopCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawView = new DrawView(this);
        setContentView(drawView);
    }

    class DrawView extends SurfaceView implements SurfaceHolder.Callback {
        private Model model;
        private Render render;

        public DrawView(Context context) {
            super(context);
            getHolder().addCallback(this);
        }

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            int levelIndex = (int)getIntent().getSerializableExtra(IntentKeyWords.LEVEL_INDEX);  // поизучать
            model = StartupDownloads.getModel().setLevelIndex(levelIndex);
            render = StartupDownloads.getRender();

            loopCanvas = new LoopCanvas(surfaceHolder,model,render);

            int[] distance = {15};
            if(levelIndex >= 11){
                distance[0] = 18;
            }
            loopMain = new ThreadLoop(){
                //loopCanvas = new LoopCanvas(surfaceHolder,model,render);
                private SimpleTimer timer = new SimpleTimer(distance[0]);

                @Override
                public void run() {
                    loopCanvas.start();

                    while (isLoop()){
                        if(timer.process()){// fps
                            model.process();

                            if(model.getGameState() == GameState.WINNING){
                                Sleeping.sleep(1500);

                                stopLoop();
                            }else
                            if(model.getGameState() == GameState.DEFEAT){
                                Sleeping.sleep(1500);

                                model.setGameState(GameState.WAITING);
                            }else
                            if(DialogYesNo.action() == DialogYesNo.YES){
                                timer.reset();
                                model.restart();
                            }

                        }
                    }

                    StopThreadLoop.stopOneThread(loopCanvas);

                    back();
                }
            };

            setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();

                    render.getButtonLeft().process(x,y, () -> model.left() );
                    render.getButtonRight().process(x,y,() -> model.right() );
                    render.getButtonRestart().process(x,y,() -> {
                        if(model.getGameState() == GameState.WAITING) {
                            model.restart();
                        }else
                        if(model.getGameState() == GameState.PROCESS || model.getGameState() == GameState.DEFEAT){
                            DialogYesNo.create("make restart ?", GameActivity.this);
                        }
                    }

                    );

                    return false;
                }
            });

            ///////////////////////////
            loopMain.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            DialogYesNo.reset();
            StopThreadLoop.stopOneThread(loopCanvas);
            StopThreadLoop.stopOneThread(loopMain);
        }

    }

    private void back(){
        try {
            Intent intent = new Intent(this, LevelsActivity.class);
            intent.putExtra(IntentKeyWords.LEVEL_DTO, new LevelDto(drawView.model.getLevelIndex(),drawView.model.getGameState()));

            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }

    private long backPressedTime;
    private Toast toast;
    private boolean click = false;
    @Override
    public void onBackPressed() {
        if(!click || System.currentTimeMillis() - backPressedTime > 2000){
            toast = Toast.makeText(this, "Press again to Exit", Toast.LENGTH_SHORT);
            toast.show();
        }else
        if(System.currentTimeMillis() - backPressedTime < 2000){
            toast.cancel();
            ///////////////////
            DialogYesNo.reset();
            loopMain.stopLoop();
        }

        click = true;
        backPressedTime = System.currentTimeMillis();
    }

 }
