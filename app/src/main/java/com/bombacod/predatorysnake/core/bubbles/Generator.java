package com.bombacod.predatorysnake.core.bubbles;

import com.bombacod.predatorysnake.core.matrix.Point;

public class Generator {
    private Point[] points;
    //////////
    private int length = 2000;
    private int[] massOfType = new int[length];
    private int[] generation = new int[length];
    private boolean[] isTypes = new boolean[length];

    private int power = 2000;
    private int hCore = 400;

    public Generator(Point[] points){ this.points = points; }

    public void addType(int type){
        isTypes[type] = true;
    }

    public void deleteType(int type){
        isTypes[type] = false;
    }

    public void process(){
        for(int i = 0;i<length;i++){
            massOfType[i] = 0;
            generation[i] = 0;
        }

        for(Point point:points){
            if(point.getValue()>hCore && isTypes[point.getType()]){ // in function
                massOfType[point.getType()]+=1;
            }
        }

        for(int i = 0;i<length;i++){
            if(massOfType[i]!=0){
                generation[i] = power/massOfType[i];
            }
        }

        for(Point point:points){
            if(point.getValue()>hCore && isTypes[point.getType()]){
                point.setValue(point.getValue()+generation[point.getType()]);
            }
        }

    }
}
