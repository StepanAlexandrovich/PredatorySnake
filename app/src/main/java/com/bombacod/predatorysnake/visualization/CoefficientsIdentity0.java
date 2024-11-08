package com.bombacod.predatorysnake.visualization;

import java.util.HashMap;

public class CoefficientsIdentity0 {
    private HashMap<Integer,double[]> typeColorsIdentity0;

    public CoefficientsIdentity0() {
        typeColorsIdentity0 = new HashMap<>();
        typeColorsIdentity0.put(0,new double[]{0.0,0.0,1.0});
        typeColorsIdentity0.put(1,new double[]{1.0,1.0,1.0});
        typeColorsIdentity0.put(2,new double[]{1.0,0.0,1.0});
        typeColorsIdentity0.put(3,new double[]{0.5,0.0,1.0});
        typeColorsIdentity0.put(4,new double[]{1.0,0.3,0.3});
        typeColorsIdentity0.put(5,new double[]{1.0,0.5,0.5});
        typeColorsIdentity0.put(6,new double[]{0.6,0.0,1.0});
        typeColorsIdentity0.put(7,new double[]{1.0,0.7,0.4});
        typeColorsIdentity0.put(8,new double[]{1.0,1.0,0.0});
        typeColorsIdentity0.put(9,new double[]{1.0,0.0,1.0});
        typeColorsIdentity0.put(10,new double[]{0.5,0.5,1.0});
        typeColorsIdentity0.put(11,new double[]{0.0,0.0,0.0});
    }

    private double[] doubles(int type){ return typeColorsIdentity0.get(type); }

    public double red(int type){ return doubles(type)[0]; }
    public double green(int type){ return doubles(type)[1]; }
    public double blue(int type){ return doubles(type)[2]; }
}
