package com.bombacod.predatorysnake.core.snake.head;

import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.DataSnake;

import java.util.List;

public class Control {
    private double[] coefficientsImpactMotors;
    private DataSnake data;

    public Control(DataSnake data) {
        this.data = data;
        coefficientsImpactMotors = new double[800];
    }

    public void directly(){
        coefficientsImpactMotors[data.getTypeMotor0()] = 1.0;
        coefficientsImpactMotors[data.getTypeMotor1()] = 1.0;
    }

    public void right(){
        coefficientsImpactMotors[data.getTypeMotor0()] = 1.5;
        coefficientsImpactMotors[data.getTypeMotor1()] = 0.3;
    }

    public void left(){
        coefficientsImpactMotors[data.getTypeMotor0()] = 0.3;
        coefficientsImpactMotors[data.getTypeMotor1()] = 1.5;
    }

    public void process(List<Point> points){
        for (Point point : points) {
            int index = point.index;
            Point pointMotors = data.getPointMotors(index);

            if(data.isMotors(index)){
                int impact = (int)(pointMotors.getValue() * coefficientsImpactMotors[pointMotors.getType()]);
                UniversalMethods.decrease(point,-impact);
            }
        }
    }

}
