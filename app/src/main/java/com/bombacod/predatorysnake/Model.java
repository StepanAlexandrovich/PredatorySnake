package com.bombacod.predatorysnake;

import com.bombacod.predatorysnake.bubbles.Bubbles;
import com.bombacod.predatorysnake.matrix.Matrix;
import com.bombacod.predatorysnake.matrix.Point;

public class Model {
    private int width = 100,height = 100;

    private Bubbles bubbles = new Bubbles(width,height);
    private Point point = bubbles.getMatrix().getPoint(width/2,height/2);

    private int vector = 4;
    private int step = 0;

    // get
    public Matrix getBubblesMatrix() {
        return bubbles.getMatrix();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // control
    public void right(){
        vector = Point.right(vector);
    }
    public void left(){
        vector = Point.left(vector);
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
        bubbles.process();
    }
}
