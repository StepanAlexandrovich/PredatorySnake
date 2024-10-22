package com.bombacod.predatorysnake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.snake.Snake;
import com.bombacod.predatorysnake.core.test.Turn;

public class Render {
    private Paint paint;
    private Bitmap bitmap;

    public Render(Model model) {
        paint = new Paint();
        bitmap = Bitmap.createBitmap(model.getWidth(),model.getHeight(),Bitmap.Config.RGB_565);
    }

    private int border(int value){
        if(value<-255) { value = -255; }
        if(value>+255) { value = +255; }
        return value;
    }
    public void draw(Canvas canvas, Model model){
        Snake snake = model.getSnake();
        Snake snakeTest = model.getSnakeTest();

        int length = model.getLength();

        for(int i = 0;i < length;i++){
            int x = model.getX(i);
            int y = model.getY(i);

            if(snake.isSnake(i)){
                bitmap.setPixel(x,y, drawSnake(snake,i,10));
            }else
            if(snakeTest.isSnake(i)){
                bitmap.setPixel(x,y, drawSnakeTest(snakeTest,i,10));
            }else
            if(true){
                bitmap.setPixel(x,y,drawTrack(model.getMatrices().getMatrixTrack(),i,1));
            }
        }

        int side = canvas.getWidth();
        Bitmap bitmapMultiplication = Bitmap.createScaledBitmap(bitmap,side,side, false);
        canvas.drawBitmap(bitmapMultiplication,0,0,paint);

        // test
        symmetryTest(canvas,model.getMatrices().getMatrixIdentity1());
    }

    private int drawSnake(Snake snake, int i, int bright){
        int head = snake.getPointHead(i).getValue();
        int motors = snake.getPointMotors(i).getValue();

        head = border(head * bright);
        motors = border(motors * bright);

        if(head>0 && motors == 255){
            return Color.argb(255,motors,head/2,000);
        }else{
            return Color.argb(255,motors,000,000);
        }
    }

    private int drawTrack(Matrix matrixTrack,int i,int bright){
        int track = matrixTrack.getPoint(i).getValue();
        track = border(track * bright);
        return Color.argb(255,000,000,track);
    }

    // test
    private int drawSnakeTest(Snake snake, int i, int bright){
        int head = snake.getPointHead(i).getValue();
        int motors = snake.getPointMotors(i).getValue();

        head = border(head * bright);
        motors = border(motors * bright);

        if(head>0 && motors == 255){
            return Color.argb(255,head/2,motors,000);
        }else{
            return Color.argb(255,000,motors,000);
        }
    }

    private void symmetryTest(Canvas canvas,Matrix matrix){
        if(Turn.turnHorizontal(matrix)){
            paint.setColor(Color.GREEN);
        }else{
            paint.setColor(Color.RED);
        }
        canvas.drawRect(0,0,100,100,paint);
    }
}
