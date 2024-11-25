package com.bombacod.predatorysnake.core.objects.snake.motors;

import com.bombacod.predatorysnake.core.interfaces.IsExisting;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.List;

public class GeneratorMotor {
    private int power;
    private int lowerBorder;

    public void setPower(int power) {
        this.power = power;
    }
    public void setLowerBorder(int lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    private boolean isCorePoint(Point point, IsExisting object){
        return point.getValue() > lowerBorder && object.isExisting(point.index);
    }

    public void process(List<Point> points, IsExisting object){
        int mass = 0;
        int generation = 0;

        for (Point point : points) {
            if(isCorePoint(point,object)){
                mass += 1;
            }
        }

        if(mass!=0){
            generation = power/mass;
        }

        for (Point point : points) {
            if(isCorePoint(point,object)){
                point.setValue(point.getValue() + generation);
            }
        }
    }
}
