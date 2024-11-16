package com.bombacod.predatorysnake.visualization;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

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

        animation.draw(model);
        buttonRestart.draw(animation.getBitmap(),widthAnimation, heightAnimation,canvas);

        buttonLeft.draw(canvas);
        buttonRight.draw(canvas);

        switch (model.gameState()){
            case GameState.DEFEAT: text("DEFEAT", model.lastEvent(),canvas); break;
            case GameState.PROCESS: text("", model.lastEvent(),canvas); break;
            case GameState.WINNING: text("YOU WON !!!!", model.lastEvent(),canvas); break;
            case GameState.INSTRUCTION: instruction(canvas); break;
        }

        test.process(canvas,model,heightAnimation - 140);
    }

    private void instruction(Canvas canvas){
        int shift = 50;
        text.drawText("CLICK ME TO START",   xLeftMargin + 150, yTop + 200 - shift,50, Color.RED,canvas);
        text.drawText("OR",                  xLeftMargin + 300, yTop + 400 - shift,50, Color.RED,canvas);
        text.drawText("CLICK ME TO RESTART", xLeftMargin + 130, yTop + 600 - shift,50, Color.RED,canvas);

        text.drawTextCircle("LEFT",buttonLeft.xCenter(),buttonLeft.yCenter(),50,100,Color.RED,canvas);
        text.drawTextCircle("RIGHT",buttonRight.xCenter(),buttonRight.yCenter(),50,100,Color.RED,canvas);
    }

    private void text(String content,String commit,Canvas canvas){
        text.drawText(content, xLeftMargin + 10, yBottom - 10,150, Color.RED,canvas);
        text.drawText(commit, xRightMargin + 50, yBottom - 50,30, Color.RED,canvas);
    }

}
