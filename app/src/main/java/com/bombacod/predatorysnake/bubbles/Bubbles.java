package com.bombacod.predatorysnake.bubbles;

import com.bombacod.predatorysnake.matrix.Matrix;
import com.bombacod.predatorysnake.matrix.Point;

public class Bubbles {
    private int width,height;

    private Matrix matrix;
    private Generator generator;

    public Bubbles(int width, int height) {
        this.width = width;
        this.height = height;

        matrix = new Matrix(width,height){
            @Override
            public Point createPoint() {
                return new PointImpl();
            }
        };

        generator = new Generator(matrix.getPoints());
    }

    public Matrix getMatrix() {
        return matrix;
    }

    ////////////////////////
    public void process(){
        for(Point point:matrix.getPoints()){ point.process(); }
        generator.process();
    }

}
