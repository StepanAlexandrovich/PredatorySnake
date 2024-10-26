package com.bombacod.predatorysnake.core.bubbles;

import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

public class Bubbles {
    private Matrix matrix;
    private Generator generator; // private

    public Bubbles(Matrix matrix) {
        this.matrix = matrix;

        generator = new Generator(matrix.getPoints());
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void startMatrix(int xBase,int yBase,int startType,int side,int multiplication){
        int type = startType;
        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                start(xBase + x*multiplication,yBase + y*multiplication,5000,type);
                type++;
            }
        }
    }

    public void start(int x, int y, int value, int type){
        Point point = matrix.getPoint(x,y);
        point.setType(type);
        point.setValue(value);
        generator.addType(point.getType());
    }

    // encapsulation
    public void deleteBubble(int type){
        generator.deleteType(type);
    }

    ////////////////////////
    public void process(){
        generator.process();
        UniversalMethods.decrease(matrix,-1);
    }

}
