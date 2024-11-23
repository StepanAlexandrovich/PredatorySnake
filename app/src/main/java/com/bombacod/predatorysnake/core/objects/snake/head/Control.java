package com.bombacod.predatorysnake.core.objects.snake.head;

import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.interfaces.PointsFunctions;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.List;

public class Control {
    public double coefficientMax,coefficientMin;
    private double coefficientBetween;
    // dynamic
    public double coefficient0,coefficient1;

    public void setCoefficientBetween(double coefficientBetween) {
        this.coefficientBetween = coefficientBetween;
    }

    public void setCoefficientMax(double coefficientMax) {
        this.coefficientMax = coefficientMax;
    }

    public void setCoefficientMin(double coefficientMin) {
        this.coefficientMin = coefficientMin;
    }

    public void directly(){
        coefficient0 = coefficientBetween;
        coefficient1 = coefficientBetween;
    }

    public void right(){
        coefficient0 = coefficientMax;
        coefficient1 = coefficientMin;
    }

    public void left(){
        coefficient0 = coefficientMin;
        coefficient1 = coefficientMax;
    }

    public void process(List<Point> points, PointsFunctions object0, PointsFunctions object1){
        for (Point point : points) {
            int index = point.index;

            if(object0.isExisting(index)){
                int impact = (int)(object0.getPoint(index).getValue() * coefficient0);
                UniversalMethods.decrease(point,-impact);
            }else
            if(object1.isExisting(index)){
                int impact = (int)(object1.getPoint(index).getValue() * coefficient1);
                UniversalMethods.decrease(point,-impact);
            }

        }
    }

}
