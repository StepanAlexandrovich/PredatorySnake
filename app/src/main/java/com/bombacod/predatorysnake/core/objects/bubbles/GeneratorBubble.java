package com.bombacod.predatorysnake.core.objects.bubbles;

import com.bombacod.predatorysnake.core.matrix.Point;
import java.util.List;

class GeneratorBubble {
    private int power;
    private int lowerBorder;

    public void setPower(int power) {
        this.power = power;
    }
    public void setLowerBorder(int lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    public void process(List<Point> points){
        int mass = 0;
        int generation = 0;

        for (Point point : points) {
            if(point.getValue() > lowerBorder){
                mass += 1;
            }
        }

        if(mass!=0){
            generation = power/mass;
        }

        for (Point point : points) {
            if(point.getValue() > lowerBorder){
                point.setValue(point.getValue() + generation);
            }
        }
    }
}
