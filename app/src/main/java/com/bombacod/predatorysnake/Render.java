package com.bombacod.predatorysnake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.bombacod.predatorysnake.bubbles.Matrix;
import com.bombacod.predatorysnake.bubbles.Point;

public class Render {
    Paint paint = new Paint();

    private int border(int value){
        if(value<-255) { value = -255; }
        if(value>+255) { value = +255; }
        return value;
    }

    public void draw(Canvas canvas,Model model){
        Matrix matrix = model.getMatrix();
        int multiplication = canvas.getWidth()/matrix.getWidth();
        int bright = 1;

        // bubbles
        for(Point point: model.getMatrix().getPoints()){
            ////////////////////////////DRAWING///////////////////////////////////
            int value = border(point.getValue()*bright);
            // материя
            if(value >0)  { paint.setColor(Color.argb(255,0,value,value)); } else
            // вакуум
            if(value == 0) { paint.setColor(Color.argb(255,0,0,255)); }

            ///////////////
            int x = point.x * multiplication;
            int y = point.y*multiplication;
            int side = multiplication;
            canvas.drawRect(x,y, x + side, y + side,paint);
            ///////////////////////////////////////////////////////////////////////
        }
    }
}
