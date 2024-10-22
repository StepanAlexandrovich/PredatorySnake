package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.core.matrix.Point;

public class UniversalMethods {

    public static void decrease(Point point,int value){
        point.addValue(value);
        if(point.getValue()<=0){
            point.reset();
        }
    }

}
