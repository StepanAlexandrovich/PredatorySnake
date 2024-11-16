package com.bombacod.predatorysnake.core.objects.obstacle;

import com.bombacod.predatorysnake.core.interfaces.IsExisting;
import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.ArrayList;
import java.util.List;

public class Fence implements IsExisting {
    private int mark;
    private List<Point> points;
    private Matrix matrixMark,matrixHead,matrixMotors;

    public Fence(int mark, Layers layers) {
        this.mark = mark;

        matrixMark = layers.getLayer3().getMatrix();

        for (Point point : matrixMark.getPoints()) {
            point.mark = mark;
        }

        for (int y = 1; y < matrixMark.getHeight() - 1; y++) {
            for (int x = 1; x < matrixMark.getWidth() - 1; x++) {
                matrixMark.getPoint(x,y).mark = 0;
            }
        }

        points = new ArrayList<>();

        for (Point point : matrixMark.getPoints()) {
            if(point.mark == mark){
                points.add(point);
            }
        }

        matrixHead = layers.getLayer0().getMatrix();
        matrixMotors = layers.getLayer1().getMatrix();
    }

    @Override
    public boolean isExisting(int index) {
        return matrixMark.getPoint(index).mark == mark;
    }

    public void process(){
        for (Point point : points) {
            matrixHead.getPoint(point.index).reset();
            matrixMotors.getPoint(point.index).reset();
        }
    }

}
