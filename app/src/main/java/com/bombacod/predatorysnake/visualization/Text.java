package com.bombacod.predatorysnake.visualization;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

// ширина текста float width = fontPaint.measureText(text);

public class Text {
    public void drawText(String text, int x, int y,int size,int color, Canvas canvas){
        Paint fontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        fontPaint.setColor(color);
        fontPaint.setTextSize(size);
        fontPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawText(text,x,y,fontPaint);
    }
}
