package com.bombacod.predatorysnake.core.snake.motors;

import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.DataSnake;

import java.util.List;

public class GeneratorMotor {
    private int power;
    private int lowerBorder;

    private DataSnake data;

    GeneratorMotor(DataSnake data){
        this.data = data;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public void setLowerBorder(int lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    private boolean isCorePoint(Point point){
        return point.getValue() > 20 && data.isHead(point.index);
    }

    public void process(List<Point> points){
        int mass = 0;
        int generation = 0;

        for (Point point : points) {
            if(isCorePoint(point)){
                mass += 1;
            }
        }

        if(mass!=0){
            generation = power/mass;
        }

        for (Point point : points) {
            if(isCorePoint(point)){
                point.setValue(point.getValue() + generation);
            }
        }
    }
}
