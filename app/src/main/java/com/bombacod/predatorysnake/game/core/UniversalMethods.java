package com.bombacod.predatorysnake.game.core;

import com.bombacod.predatorysnake.game.core.matrix.Matrix;
import com.bombacod.predatorysnake.game.core.matrix.Point;

import java.util.List;

public class UniversalMethods {

    // decrease
    public static void decrease(Point point, int value){
        point.addValue(value);
        if(point.getValue()<=0){
            point.reset();
        }
    }

    public static void decrease(Matrix matrix, int value){
        for (Point point : matrix.getPoints()) {
            decrease(point,value);
        }
    }

    public static void decrease(List<Point> points, int value){
        for (Point point : points) {
            decrease(point,value);
        }
    }

    ////////////.........
}
