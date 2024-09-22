package com.bombacod.predatorysnake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.bombacod.predatorysnake.bubbles.Matrix;
import com.bombacod.predatorysnake.bubbles.Point;

import java.util.Map;

public class Render {
    private Paint paint;
    private Bitmap bitmap;

    public Render(int width, int height) {
        paint = new Paint();
        bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.RGB_565);
    }

    private int border(int value){
        if(value<-255) { value = -255; }
        if(value>+255) { value = +255; }
        return value;
    }

    public void draw(Canvas canvas,Model model){
        Matrix matrix = model.getMatrix();
        int bright = 1;

        for(Point point: matrix.getPoints()){
            int value = border(point.getValue()*bright);
            // материя
            if(value >0)  { bitmap.setPixel(point.x,point.y,Color.argb(255,0,value,value)); } else
            // вакуум
            if(value == 0) { bitmap.setPixel(point.x,point.y,Color.argb(255,0,0,255)); }
        }

        int side = canvas.getWidth();
        Bitmap bitmapMult = Bitmap.createScaledBitmap(bitmap,side,side, false);
        canvas.drawBitmap(bitmapMult,0,0,paint);
    }
}
