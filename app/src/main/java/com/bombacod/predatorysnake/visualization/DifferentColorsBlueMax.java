package com.bombacod.predatorysnake.visualization;

import android.graphics.Color;

import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.HashMap;

public class DifferentColorsBlueMax {
    private HashMap<Integer,double[]> types;

    public DifferentColorsBlueMax() {
        types = new HashMap<>();
        types.put(0,new double[]{0.0,0.0,1.0});
        types.put(1,new double[]{1.0,1.0,1.0});
        types.put(2,new double[]{1.0,0.0,1.0});
        types.put(3,new double[]{0.0,1.0,1.0});
        types.put(4,new double[]{0.5,0.5,0.3});
        types.put(5,new double[]{1.0,0.5,0.5});
        types.put(6,new double[]{0.6,0.0,1.0});
        types.put(7,new double[]{1.0,0.7,0.4});
        types.put(8,new double[]{1.0,1.0,0.0});
        types.put(9,new double[]{1.0,0.0,1.0});
        types.put(10,new double[]{0.5,0.5,1.0});
        types.put(11,new double[]{0.0,0.0,0.0});
    }

    private int border(int value){
        if(value<-255) { value = -255; }
        if(value>+255) { value = +255; }
        return value;
    }

    private double[] doubles(int type){ return types.get(type); }

    public double red(int type){ return doubles(type)[0]; }
    public double green(int type){ return doubles(type)[1]; }
    public double blue(int type){ return doubles(type)[2]; }

    public int draw(Point point, double bright){
        int type = point.getType();

        int value = border((int)(point.getValue() * bright));

        double red = doubles(type)[0];
        double green = doubles(type)[1];
        double blue = doubles(type)[2];

        return Color.argb(255,(int)(value*red),(int)(value*green),255);
    }
}
