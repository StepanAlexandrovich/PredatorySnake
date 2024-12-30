package com.bombacod.predatorysnake.game.visualization.top;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.bombacod.predatorysnake.game.visualization.buttons.Button;
import com.bombacod.predatorysnake.timing.StopWatch;

public class DrawImageIncrease {
    private StopWatch stopWatch;

    public DrawImageIncrease(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    private boolean start;
    private double coefficient;
    private final double startCoefficient = 0.2;

    public void reset(){
        start = true;
        coefficient = startCoefficient;
    }
    public void process(Button button,Bitmap image, Canvas canvas){
        if(start){
            stopWatch.start();
            start = false;
        }

        if(stopWatch.getTime() < 600){
            coefficient = (double)stopWatch.getTime()/600 + startCoefficient;
            button.drawCenter(image,(int)(button.width/2 * coefficient), (int)(button.height/2 * coefficient), canvas);
        }else
        if(stopWatch.getTime() >= 600){
            button.drawCenter(image,(int)(button.width/2 * coefficient), (int)(button.height/2 * coefficient), canvas);
        }
    }
}
