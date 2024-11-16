package com.bombacod.predatorysnake.visualization;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

// ширина текста float width = fontPaint.measureText(text);

public class Text {
    public void drawText(String text, int x, int y,int size,int color, Canvas canvas){
        Paint fontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        fontPaint.setColor(color);
        fontPaint.setTextSize(size);
//        fontPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        fontPaint.setStyle(Paint.Style.FILL);

        canvas.drawText(text,x,y,fontPaint);
    }

    public void drawTextCircle(String text, int xCenter, int yCenter,int size,int radius,int color, Canvas canvas){
        Paint fontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        fontPaint.setColor(color);
        fontPaint.setTextSize(size);
        fontPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        Path path = new Path();
        path.addCircle(xCenter,yCenter,radius,Path.Direction.CW);
        canvas.drawTextOnPath(text,path,0,0,fontPaint);
    }

}
