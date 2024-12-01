package com.bombacod.predatorysnake.visualization;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import com.bombacod.predatorysnake.Images;
import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.pf.GameState;
import com.bombacod.predatorysnake.visualization.buttons.Button;
import com.bombacod.predatorysnake.visualization.buttons.ButtonControl;
import com.bombacod.predatorysnake.visualization.buttons.ButtonRestart;

public class Render {
    private Animation animation;

    private ButtonControl buttonLeft;
    private ButtonControl buttonRight;
    private ButtonRestart buttonRestart;

    private Text text;
    private TestVisualization test = new TestVisualization();

    private int widthAnimation, heightAnimation;
    private int xLeft, xLeftMargin, xRightMargin, xRight, yTop, yBottom;

    public Render() {
        text = new Text();
    }

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
        buttonRestart = new ButtonRestart(xLeftMargin, yTop, xRightMargin, yBottom);
        buttonRight = new ButtonControl(xRightMargin, yTop, xRight, yBottom);
    }

    public void draw(Model model,Canvas canvas){
        if(start){
            initialization(model,canvas);
            start = false;
        }


        if(model.gameState() == GameState.WAITING){
            buttonRestart.draw(Images.restart,canvas);
        }else{
            animation.draw(model);
            buttonRestart.draw(animation.getBitmap(),canvas);
        }

        buttonLeft.draw(canvas);
        buttonRight.draw(canvas);

        switch (model.gameState()){
            case GameState.DEFEAT:
                drawImage(Images.defeat,canvas);
                text(model.lastEvent(),canvas);
                break;
            case GameState.PROCESS:
                text(model.lastEvent(),canvas);
                break;
            case GameState.WINNING:
                drawImage(Images.win,canvas);
                text(model.lastEvent(),canvas);
                break;
            case GameState.WAITING: waiting(canvas); break;
        }

        //test.process(canvas,model,heightAnimation - 140);
    }

    private void waiting(Canvas canvas){
        text.drawTextCircle("LEFT",buttonLeft.xCenter(),buttonLeft.yCenter(),buttonLeft.getRadius()/2,buttonLeft.getRadius(),Color.RED,canvas);
        text.drawTextCircle("RIGHT",buttonRight.xCenter(),buttonRight.yCenter(),buttonLeft.getRadius()/2,buttonLeft.getRadius(),Color.RED,canvas);
    }

    private void text(String commit,Canvas canvas){
        text.drawText(commit, xRightMargin + 50, yBottom - 50,30, Color.RED,canvas);
    }

    private void drawImage(Bitmap image,Canvas canvas){
        buttonRestart.drawCenter(image,widthAnimation/2,heightAnimation/2,canvas);
    }

}
