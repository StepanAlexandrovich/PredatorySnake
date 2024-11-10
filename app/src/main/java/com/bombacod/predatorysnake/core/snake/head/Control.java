package com.bombacod.predatorysnake.core.snake.head;

import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.interfaces.PointsFunctions;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.List;

public class Control {
    private double coefficient0,coefficient1;

    public void directly(){
        coefficient0 = 1.0;
        coefficient1 = 1.0;
    }

    public void right(){
        coefficient0 = 1.5;
        coefficient1 = 0.3;
    }

    public void left(){
        coefficient0 = 0.3;
        coefficient1 = 1.5;
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
