package com.bombacod.predatorysnake.visualization;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.obstacle.Fence;
import com.bombacod.predatorysnake.core.snake.Snake;

public class Render {   // Color.arb -> long -> remake
    private Paint paint;
    private Bitmap bitmap;
    private Text text;

    private DifferentColors differentColors;
    private TestVisualization test = new TestVisualization();

    public Render() { // избавиться
        paint = new Paint();
        text = new Text();

        differentColors = new DifferentColors();
    }

    private int border(int value){
        if(value<-255) { value = -255; }
        if(value>+255) { value = +255; }
        return value;
    }

    public void draw(Canvas canvas, Model model){
        if(bitmap == null){
            bitmap = Bitmap.createBitmap(model.getWidth(),model.getHeight(),Bitmap.Config.RGB_565);
        }

        Snake snake = model.getSnake();
        Snake snakeTest = model.getSnakeTest();
        Fence fence = model.getFence();

        int length = model.getLength();

        for(int i = 0;i < length;i++){
            int x = model.getX(i);
            int y = model.getY(i);

            if(snake.isExisting(i)){
                bitmap.setPixel(x,y, drawSnake(snake,i,10));
            }else
//            if(snakeTest.isExisting(i)){
//                bitmap.setPixel(x,y, drawSnakeTest(snakeTest,i,10));
//            }else
            if(fence.isExisting(i)){
                bitmap.setPixel(x,y, drawFence(model.getMatrix3(), i,10));
            }else
            if(model.getMatrix0().getPoint(i).getValue() > 0){ // remake
                bitmap.setPixel(x,y, differentColors.draw(model.getMatrix0().getPoint(i),10));
            }else
            if(true){
                bitmap.setPixel(x,y,drawTrack(model.getMatrix2(),i,0.5));
            }
        }

        int side = canvas.getWidth();
        Bitmap bitmapMultiplication = Bitmap.createScaledBitmap(bitmap,side,side, false);
        canvas.drawBitmap(bitmapMultiplication,0,0,paint);

        text.drawText(model.gameStateText(), 50,side,50,Color.RED,canvas);

        //test.process(canvas,model,side);
    }

    //// objects ////
    private int drawSnake(Snake snake, int i, int bright){
        int head = snake.getPointHead(i).getValue();
        int motors = snake.getPointMotors(i).getValue();

        head = border(head * bright);
        motors = border(motors * bright);

        if(head>0 && motors == 255){
            return Color.argb(255,motors,head/2,000);
        }else
        if(head>0 && motors == 0){
            return differentColors.draw(snake.getPointHead(i),bright);
        } else{
            return Color.argb(255,motors,000,000);
        }
    }

    private int drawTrack(Matrix matrixTrack,int i,double bright){
        int track = matrixTrack.getPoint(i).getValue();
        track = border((int)(track * bright));
        if(track > 0){ track = track * 2; }
        return Color.argb(255,000,000,track);
    }

    private int drawFence(Matrix matrix,int i,double bright){
        int value = matrix.getPoint(i).getValue();
        value = border((int)(value * bright));
        return Color.argb(255,000,255,255);
    }

    // future
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

}
