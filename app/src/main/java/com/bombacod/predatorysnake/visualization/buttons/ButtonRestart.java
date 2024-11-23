package com.bombacod.predatorysnake.visualization.buttons;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class ButtonRestart extends Button{
    private Paint paint;

    public ButtonRestart(int x0, int y0, int x1, int y1) {
        super(x0, y0, x1, y1);

        paint = new Paint();
    }

    public void draw(Bitmap bitmap, int widthImage,int heightImage,Canvas canvas){
        Bitmap image = Bitmap.createScaledBitmap(bitmap, widthImage, heightImage, false);
        canvas.drawBitmap(image,x0,y0,paint);
    }

}
