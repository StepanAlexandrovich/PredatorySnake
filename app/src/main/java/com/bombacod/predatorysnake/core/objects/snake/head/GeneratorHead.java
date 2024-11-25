package com.bombacod.predatorysnake.core.objects.snake.head;

import com.bombacod.predatorysnake.core.interfaces.IsExisting;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.List;

public class GeneratorHead {
    private int power;
    private int lowerBorder;

    public void setPower(int power) {
        this.power = power;
    }
    public void setLowerBorder(int lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    private boolean isCore(Point point, IsExisting object0, IsExisting object1){
        int index = point.index;
        return point.getValue() > lowerBorder && !object0.isExisting(index) && !object1.isExisting(index);
    }

    public void process(List<Point> points, IsExisting object0, IsExisting object1){
        int mass = 0;
        int generation = 0;

        for (Point point : points) {
            if(isCore(point,object0,object1)){
                mass += 1;
            }
        }

        if(mass!=0){
            generation = power/mass;
        }

        for (Point point : points) {
            if(isCore(point,object0,object1)){
                point.setValue(point.getValue() + generation);
            }
        }
    }
}
