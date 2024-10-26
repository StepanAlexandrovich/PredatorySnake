package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

public class UniversalMethods {

    public static void decrease(Point point,int value){
        point.addValue(value);
        if(point.getValue()<=0){
            point.reset();
        }
    }

    public static void decrease(Matrix matrix,int value){
        for (Point point : matrix.getPoints()) {
            point.addValue(value);
            if(point.getValue()<=0){
                point.reset();
            }
        }
    }

}
