package com.bombacod.predatorysnake.core.objects.snake.head;

import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.interfaces.PointsFunctions;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.List;

public class Control {
    public double MAX = 1.5,MIN = 0.3;  // remake
    private double coefficient0,coefficient1;

    public void directly(){
        coefficient0 = MIN;
        coefficient1 = MIN;
    }

    public void right(){
        coefficient0 = MAX;
        coefficient1 = MIN;
    }

    public void left(){
        coefficient0 = MIN;
        coefficient1 = MAX;
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
