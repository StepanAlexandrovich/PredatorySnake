package com.bombacod.predatorysnake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.Snake;
import com.bombacod.predatorysnake.core.test.Turn;

import java.util.HashMap;

public class Render {
    private Paint paint;
    private Bitmap bitmap;

    private HashMap<Integer,double[]> typeColorsIdentity0;

    public Render(Model model) {
        paint = new Paint();
        bitmap = Bitmap.createBitmap(model.getWidth(),model.getHeight(),Bitmap.Config.RGB_565);

        typeColorsIdentity0 = new HashMap<>();
        //typeColors.put(0,new double[]{0.0,0.0,1.0});
        typeColorsIdentity0.put(1,new double[]{1.0,1.0,1.0});
        typeColorsIdentity0.put(2,new double[]{1.0,0.0,1.0});
        typeColorsIdentity0.put(3,new double[]{0.5,0.0,1.0});
        typeColorsIdentity0.put(4,new double[]{1.0,0.3,0.3});
        typeColorsIdentity0.put(5,new double[]{1.0,0.5,0.5});
        typeColorsIdentity0.put(6,new double[]{0.6,0.0,1.0});
        typeColorsIdentity0.put(7,new double[]{1.0,0.7,0.4});
        typeColorsIdentity0.put(8,new double[]{1.0,1.0,0.0});
        typeColorsIdentity0.put(9,new double[]{1.0,0.0,1.0});
        typeColorsIdentity0.put(10,new double[]{0.5,0.5,1.0});
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
            if(model.getMatrices().getMatrixIdentity0().getPoint(i).getValue() >0){
                bitmap.setPixel(x,y, drawBubbles(model.getMatrices().getMatrixIdentity0(),i,10));
            }else
            if(true){
                bitmap.setPixel(x,y,drawTrack(model.getMatrices().getMatrixTrack(),i,0.5));
            }
        }

        int side = canvas.getWidth();
        Bitmap bitmapMultiplication = Bitmap.createScaledBitmap(bitmap,side,side, false);
        canvas.drawBitmap(bitmapMultiplication,0,0,paint);

        // test
        //symmetryTest(canvas,model.getMatrices().getMatrixIdentity1());
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

    private int drawBubbles(Matrix matrix, int i, int bright){
        Point point = matrix.getPoint(i);

        int value = point.getValue();
        value = border(value * bright);

        double[] doubles = typeColorsIdentity0.get(point.getType());

        return Color.argb(255,(int)(value*doubles[0]),(int)(value*doubles[1]),(int)(value*doubles[2]));
    }

    private int drawTrack(Matrix matrixTrack,int i,double bright){
        int track = matrixTrack.getPoint(i).getValue();
        track = border((int)(track * bright));
        if(track > 0){ track = track * 2; }
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
