package com.bombacod.predatorysnake.core.obstacle;

import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.ArrayList;
import java.util.List;

public class Fence {  // implements
    private int type;
    private List<Point> points;
    private Matrix matrixMark;

    public Fence(int type, Layers layers) {
        this.type = type;

        matrixMark = layers.getPlane3().getMatrix();
        for (Point point : matrixMark.getPoints()) {
            point.setType(type);
        }

        for (int y = 1; y < matrixMark.getHeight() - 1; y++) {
            for (int x = 1; x < matrixMark.getWidth() - 1; x++) {
                matrixMark.getPoint(x,y).reset();
            }
        }

        points = new ArrayList<>();
        Matrix matrix = layers.getPlane0().getMatrix();
        for (Point pointMark : matrixMark.getPoints()) {
            if(pointMark.getType() == type){
                points.add(matrix.getPoint(pointMark.index));
            }
        }

    }

    public boolean isFence(int index){
        return matrixMark.getPoint(index).getType() == type;
    }  // remake name

    public void process(){
        for (Point point : points) {
            point.reset();
        }
    }
}
