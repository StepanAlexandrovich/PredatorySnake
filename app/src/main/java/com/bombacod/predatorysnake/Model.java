package com.bombacod.predatorysnake;

import com.bombacod.predatorysnake.bubbles.Generator;
import com.bombacod.predatorysnake.bubbles.Matrix;
import com.bombacod.predatorysnake.bubbles.Point;

public class Model {
    private int width = 100,height = 100;

    private Matrix matrix = new Matrix(width,height);
    private Generator generator = new Generator(matrix.getPoints());
    private Point point = matrix.getPoint(width/2,height/2);

    private int vector = 4;
    private int step = 0;

    public Matrix getMatrix() {
        return matrix;
    }

    //
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // control
    public void right(){
        vector++;
        if(vector == 5){ vector = 1; }
    }
    public void left(){
        vector--;
        if(vector == 0){ vector = 4; }
    }

    ///////////////////////////////////
    public void process(){
        step++;

        // controlled point
        point = point.points[vector];

        if(step%2 == 0){
            point.setType(step);
            point.setValue(2000);
        }

        // bubbles
        for(Point point:matrix.getPoints()){ point.process(); }
        generator.process();
    }
}
