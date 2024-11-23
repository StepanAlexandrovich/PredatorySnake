package com.bombacod.predatorysnake.visualization;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.objects.obstacles.Obstacles;
import com.bombacod.predatorysnake.core.objects.snake.Snake;
import com.bombacod.predatorysnake.pf.Filling;

public class Animation { // Color.arb -> long -> remake
    private Bitmap bitmap;
    private DifferentColors differentColors;
    private DifferentColorsBlueMax differentColorsBlueMax;

    private double brightSnake = 10;
    private double brightTrack = 0.5;
    private double brightBubbles = 5;

    public Animation() {
        differentColors = new DifferentColors();
        differentColorsBlueMax = new DifferentColorsBlueMax();
    }

    public Bitmap getBitmap() { return bitmap; }

    private int border(int value){
        if(value<-255) { value = -255; }
        if(value>+255) { value = +255; }
        return value;
    }

    public void draw(Model model){
        if(bitmap == null){
            bitmap = Bitmap.createBitmap(model.getWidth(),model.getHeight(),Bitmap.Config.RGB_565);
        }

        Snake snake = model.getSnake();
        Obstacles obstacles = model.getObstacles();

        int length = model.getLength();

        for(int i = 0;i < length;i++){
            int x = model.getX(i);
            int y = model.getY(i);

            if(snake.isExisting(i)){
                bitmap.setPixel(x,y, drawSnake(snake,i,brightSnake));
            }else
            if(obstacles.isExisting(i)){
                bitmap.setPixel(x,y, drawFence(model.getMatrix3(), i,10));
            }else
            // плохой подход
            if(model.getMatrix2().getPoint(i).getValue() != Filling.filling2 && model.getMatrix0().getPoint(i).getValue() != Filling.filling0){
                bitmap.setPixel(x,y, drawTrackAndBubble(model.getMatrix2(), model.getMatrix0(), i,brightTrack,brightBubbles));
            }else
            if(model.getMatrix0().getPoint(i).getValue() != Filling.filling0){
                bitmap.setPixel(x,y, differentColorsBlueMax.draw(model.getMatrix0().getPoint(i),brightBubbles));
            }else
            if(true){
                bitmap.setPixel(x,y,drawTrack(model.getMatrix2(),i,brightTrack));
            }

        }
    }

    //// objects ////
    private int drawSnake(Snake snake,int i, double bright){
        int head = snake.getPointHead(i).getValue();
        int motors = snake.getPointMotors(i).getValue();

        head = border((int)(head * bright));
        motors = border((int)(motors * bright));

        if(head>0 && motors == 255){
            return Color.argb(255,motors,head/2,000);
        }else
        if(head>0 && motors == 0){
            return differentColors.draw(snake.getPointHead(i),bright);
        } else{
            return Color.argb(255,motors,000,000);
        }
    }

    private int drawTrack(Matrix matrixTrack, int i, double bright){
        int track = matrixTrack.getPoint(i).getValue();
        track = border((int)(track * bright));
        if(track > 0){ track = track * 2; }
        return Color.argb(255,000,000,track);
    }

    private int drawTrackAndBubble(Matrix matrixTrack, Matrix matrixBubbles, int i, double brightTrack, double brightBubble){
        int track = matrixTrack.getPoint(i).getValue();
        int bubble = matrixBubbles.getPoint(i).getValue();
        track = border((int)(track * brightTrack));
        bubble = border((int)(bubble * brightBubble));
        if(track > 0){ track = track * 2; }
        return Color.argb(255,000,bubble,track);
    }

    private int drawFence(Matrix matrix,int i,double bright){
        int value = matrix.getPoint(i).getValue();
        value = border((int)(value * bright));
        return Color.argb(255,000,255,255);
    }

}
