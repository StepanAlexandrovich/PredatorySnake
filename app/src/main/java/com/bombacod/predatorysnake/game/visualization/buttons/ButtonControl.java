package com.bombacod.predatorysnake.game.visualization.buttons;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import com.bombacod.predatorysnake.pf.Images;

public class ButtonControl extends Button{
    private int radius;
    private int x0Circle,y0Circle,widthCircle,heightCircle;

    private int radiusPress;
    private int x0CirclePress,y0CirclePress,widthCirclePress,heightCirclePress;

    public ButtonControl(int x0, int y0, int x1, int y1) {
        super(x0, y0, x1, y1);

        radius = (x1 - x0)/4;

        x0Circle = xCenter() - radius;
        y0Circle = yCenter() - radius;
        widthCircle = 2*radius;
        heightCircle = 2*radius;

        radiusPress = (x1 - x0)/5;

        x0CirclePress = xCenter() - radiusPress;
        y0CirclePress = yCenter() - radiusPress;
        widthCirclePress = 2*radiusPress;
        heightCirclePress = 2*radiusPress;
    }

    public int xCenter() { return xCenter; }
    public int yCenter() { return yCenter; }
    public int getRadius() { return radius; }

    public void draw(Canvas canvas){
        drawRectangle(x0,y0,x1,y1,Color.BLACK,canvas);

        if(isClick()){
            drawCircle(x0CirclePress,y0CirclePress,widthCirclePress,heightCirclePress,canvas);

            resetIsClick();
        } else {
            drawCircle(x0Circle,y0Circle,widthCircle,heightCircle,canvas);
        }

    }
    public void drawInstruction(Bitmap bitmap,Canvas canvas){
        drawRectangle(x0,y0,x1,y1,Color.BLACK,canvas);
        drawCircle(x0Circle,y0Circle,(int)(widthCircle*1.3),(int)(heightCircle*1.3),bitmap,canvas);
    }
    public void drawRectangle(int x0,int y0,int x1,int y1,int color,Canvas canvas){
        paint.setColor(color);
        canvas.drawRect(x0,y0,x1,y1,paint);
    }
    public void drawCircle(int x,int y,int width,int height,Canvas canvas){
        Bitmap image = Bitmap.createScaledBitmap(Images.getControl(),width,height, false);
        canvas.drawBitmap(image,x,y,paint);
    }

    public void drawCircle(int x,int y,int width,int height,Bitmap bitmap,Canvas canvas){
        Bitmap image = Bitmap.createScaledBitmap(bitmap,width,height, false);
        canvas.drawBitmap(image,x,y,paint);
    }

}
