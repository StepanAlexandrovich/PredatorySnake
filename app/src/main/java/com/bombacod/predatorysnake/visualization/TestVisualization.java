package com.bombacod.predatorysnake.visualization;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.bombacod.predatorysnake.SimpleTimer;
import com.bombacod.predatorysnake.SpeedMeasurement;
import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.test.Turn;

public class TestVisualization {
    private Text text = new Text();

    private int distance = 1000;
    private SpeedMeasurement speedMeasurement= new SpeedMeasurement(distance);
    private SimpleTimer timer = new SimpleTimer(distance);

    private Paint paint = new Paint();

    public void process(Canvas canvas, Model model , int side){
        paint.setColor(Color.BLACK);
        canvas.drawRect(0,side,side,side + 300,paint);

//        symmetryTest(canvas,model.getMatrices().getMatrixIdentity1());
//        timerTest(canvas,side);
//        speedTestRendering(canvas,side);
        speedTestModel(canvas,model,side);
    }

    private void symmetryTest(Canvas canvas, Matrix matrix){
        if(Turn.turnHorizontal(matrix)){
            paint.setColor(Color.GREEN);
        }else{
            paint.setColor(Color.RED);
        }
        canvas.drawRect(0,800,100,900,paint);
    }

    private void timerTest(Canvas canvas,int side){
        timer.process();
        text.drawText(timer.getStepHitText(),200,side + 100,100, Color.RED,canvas);
    }

    private void speedTestRendering(Canvas canvas, int side){
        text.drawText("" + speedMeasurement.process(),400,side + 100,100,Color.RED,canvas);
    }

    private void speedTestModel(Canvas canvas,Model model, int side){
        text.drawText(model.speedMeasurement.getSpeedText(),400,side + 100,100,Color.RED,canvas);
    }
}
