package com.bombacod.predatorysnake.game.visualization.top;

import android.graphics.Canvas;
import android.graphics.Color;

import com.bombacod.predatorysnake.pf.DefeatCommit;
import com.bombacod.predatorysnake.timing.StopWatch;
import com.bombacod.predatorysnake.pf.Images;
import com.bombacod.predatorysnake.game.core.Model;
import com.bombacod.predatorysnake.game.visualization.animation.Animation;
import com.bombacod.predatorysnake.game.visualization.buttons.Button;
import com.bombacod.predatorysnake.game.visualization.buttons.ButtonControl;
import com.bombacod.predatorysnake.pf.GameState;

public class Render {
    private Animation animation;
    private ButtonControl buttonLeft;
    private ButtonControl buttonRight;
    private Button buttonRestart;

    private Text text = new Text();
    private TestVisualization test = new TestVisualization();

    private int widthAnimation, heightAnimation;
    private int xLeft, xLeftMargin, xRightMargin, xRight, yTop, yBottom;
    private StopWatch stopWatch = new StopWatch();
    private DrawImageIncrease drawImageIncrease = new DrawImageIncrease(stopWatch);

    public Button getButtonLeft() { return buttonLeft; }
    public Button getButtonRight() { return buttonRight; }
    public Button getButtonRestart() { return buttonRestart; }

    private boolean start = true;

    private void initialization(Model model,Canvas canvas){
        int widthCanvas = canvas.getWidth();
        int heightCanvas = canvas.getHeight();

        heightAnimation = heightCanvas;
        widthAnimation = (heightAnimation * model.getWidth())/model.getHeight();

        int margin = (widthCanvas - widthAnimation)/2;
        xLeft = 0;
        xRight = widthCanvas;
        yTop = 0;
        yBottom = heightCanvas;

        xLeftMargin =  xLeft + margin;
        xRightMargin = xRight - margin;

        animation = new Animation();
        buttonLeft = new ButtonControl(xLeft, yTop, xLeftMargin, yBottom);
        buttonRestart = new Button(xLeftMargin, yTop, xRightMargin, yBottom);
        buttonRight = new ButtonControl(xRightMargin, yTop, xRight, yBottom);
    }

    public void draw(Model model,Canvas canvas){
        if(start){
            initialization(model,canvas);
            start = false;
        }

        if(model.gameState() == GameState.WAITING){
            buttonRestart.draw(Images.getRestart(),canvas);
        }else
        if(model.getStep() == 0){ // временное решение что бы рамка не мерцала на старте
            buttonRestart.draw(Images.getRestart(),canvas);
        }else
        if(model.getStep() > 0){
            animation.draw(model);
            buttonRestart.draw(animation.getBitmap(),canvas);
        }

        if(model.getStep()<15){ drawImageIncrease.reset(); } // грубое решение

        buttonLeft.draw(canvas);
        buttonRight.draw(canvas);

        switch (model.gameState()){
            case GameState.PROCESS:
                text(model.lastEvent(),canvas);
                break;
            case GameState.DEFEAT:
                if(model.getDefeatCommit() == DefeatCommit.TIME_IS_UP){
                    drawImageIncrease.process(buttonRestart,Images.getTimeIsUp(),canvas);
                }else
                if(model.getDefeatCommit() == DefeatCommit.DEATH){
                    drawImageIncrease.process(buttonRestart,Images.getDeath(),canvas);
                }
                text(model.lastEvent(),canvas);
                break;
            case GameState.WINNING:
                drawImageIncrease.process(buttonRestart,Images.getWin(),canvas);
                text(model.lastEvent(),canvas);
                break;
            case GameState.WAITING: waiting(canvas); break;
        }

        //test.process(canvas,model,heightAnimation - 140);
    }

    private void waiting(Canvas canvas){
        buttonRestart.draw(Images.getRestart(),canvas);
        text.drawTextCircle("LEFT",buttonLeft.xCenter(),buttonLeft.yCenter(),buttonLeft.getRadius()/2,buttonLeft.getRadius(),Color.RED,canvas);
        text.drawTextCircle("RIGHT",buttonRight.xCenter(),buttonRight.yCenter(),buttonLeft.getRadius()/2,buttonLeft.getRadius(),Color.RED,canvas);
    }

    private void text(String commit,Canvas canvas){
        text.drawText(commit, xRightMargin + 50, yBottom - 50,30, Color.RED,canvas);
    }

}
