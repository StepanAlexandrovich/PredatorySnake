package com.bombacod.predatorysnake.visualization;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.bombacod.predatorysnake.SpeedMeasurement;
import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.Snake;
import com.bombacod.predatorysnake.core.test.Turn;

import java.util.HashMap;

public class Render {
    private Paint paint;
    private Bitmap bitmap;
    private Text text;

    private HashMap<Integer,double[]> typeColorsIdentity0;
    private CoefficientsIdentity0 identity0;

    // test
    private SpeedMeasurement speedMeasurement;

    public Render(Model model) {
        paint = new Paint();
        bitmap = Bitmap.createBitmap(model.getWidth(),model.getHeight(),Bitmap.Config.RGB_565);
        text = new Text();

        identity0 = new CoefficientsIdentity0();
        // test
        speedMeasurement = new SpeedMeasurement(1000);
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
        speedMeasurement.process();
        text.drawText(speedMeasurement.getDifferenceText(),50,120,100,Color.RED,canvas);
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

        int type = point.getType();
        int value = border(point.getValue() * bright);

        double red = identity0.red(type);
        double green = identity0.green(type);
        double blue = identity0.blue(type);

        return Color.argb(255,(int)(value*red),(int)(value*green),(int)(value*blue));
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
