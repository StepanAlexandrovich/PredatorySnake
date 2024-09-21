package com.bombacod.predatorysnake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Render {
    Paint paint = new Paint();

    public void draw(Canvas canvas,Model model){
        canvas.drawColor(Color.GREEN);
        canvas.drawRect(model.getValue(),0,model.getValue() + 50,50,paint);
    }
}
