package com.bombacod.predatorysnake.core.snake.head;

import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.DataSnake;

import java.util.List;

public class GeneratorHead {
    private int power;
    private int lowerBorder;

    private DataSnake data;

    public GeneratorHead(DataSnake data) {
        this.data = data;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public void setLowerBorder(int lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    private boolean isCore(Point point){
        return point.getValue() > lowerBorder && !data.isMotors(point.index);
    }

    public void process(List<Point> points){
        int mass = 0;
        int generation = 0;

        for (Point point : points) {
            if(isCore(point)){
                mass += 1;
            }
        }

        if(mass!=0){
            generation = power/mass;
        }

        for (Point point : points) {
            if(isCore(point)){
                point.setValue(point.getValue() + generation);
            }
        }
    }
}
