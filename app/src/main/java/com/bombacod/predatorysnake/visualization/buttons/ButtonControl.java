package com.bombacod.predatorysnake.visualization.buttons;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class ButtonControl extends Button{
    private int xCenter,yCenter;
    private Paint paint;

    public ButtonControl(int x0, int y0, int x1, int y1) {
        super(x0, y0, x1, y1);

        xCenter = (x0 + x1)/2;
        yCenter = (y0 + y1)/2;

        paint = new Paint();
    }

    public int xCenter() { return xCenter; }
    public int yCenter() { return yCenter; }

    public void draw(Canvas canvas){
        int rad = 0;

        if(isClick()){
            rad = 80;
            resetIsClick();
        } else {
            rad = 50;
        }

        drawRectangle(x0,y0,x1,y1,Color.BLACK,canvas);
        drawCircle(xCenter,yCenter,rad,Color.GREEN,canvas);
    }

    public void drawCircle(int xCenter,int yCenter,int rad,int color,Canvas canvas){
        paint.setColor(color);
        canvas.drawCircle(xCenter,yCenter,rad,paint);
    }

    public void drawRectangle(int x0,int y0,int x1,int y1,int color,Canvas canvas){
        paint.setColor(color);
        canvas.drawRect(x0,y0,x1,y1,paint);
    }

}
