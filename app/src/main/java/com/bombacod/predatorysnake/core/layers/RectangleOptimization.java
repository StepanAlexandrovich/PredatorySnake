package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Next;
import com.bombacod.predatorysnake.core.matrix.Point;

public class RectangleOptimization extends Next {
    private int xLeft,xRight,yBottom,yTop;
    private Matrix matrix;

    public RectangleOptimization(Matrix matrix) {
        this.matrix = matrix;
        reset();
    }

    public void reset(){
        xLeft = 0;
        xRight = matrix.getWidth() - 1;
        yTop = 0;
        yBottom = matrix.getHeight() - 1;
    }

    @Override
    public void process(){
        yTop();
        yBottom();
        xLeft();
        xRight();

        for (int y = yTop - 2; y <= yBottom + 2; y++) {
            for (int x = xLeft - 2; x <= xRight + 2; x++) {
                if(matrix.isPoint(x,y)){
                    Point point = matrix.getPoint(x,y);

                    //if(point.now() != now){ point.next(); }

                    //point.processNext();
                }
            }
        }

    }

    public void yTop() {
        int length = 0;

        int y = yTop;
        while (!scannerY(y) && length < matrix.getHeight() + 1){
            y++;
            length++;
        }
        yTop = y - 1;
    }

    public void yBottom() {
        int length = 0;

        int y = yBottom;
        while (!scannerY(y) && length < matrix.getHeight() + 1){
            length ++;
            y--;
        }
        yBottom = y + 1;
    }

    public void xLeft() {
        int length = 0;

        int x = xLeft;
        while (!scannerX(x) && length < matrix.getWidth() + 1){
            x++;
            length++;
        }
        xLeft = x - 1;
    }

    public void xRight() {
        int length = 0;

        int x = xRight;
        while (!scannerX(x) && length < matrix.getWidth() + 1){
            x--;
            length++;
        }
        xRight = x + 1;
    }

    public boolean scannerY(int y){
        for (int x = xLeft; x <= xRight; x++) {
            if(matrix.isPoint(x,y) && matrix.getPoint(x,y).getValue() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean scannerX(int x){
        for (int y = yTop; y <= yBottom; y++) {
            if(matrix.isPoint(x,y) && matrix.getPoint(x,y).getValue() > 0) {
                return true;
            }
        }
        return false;
    }

}
