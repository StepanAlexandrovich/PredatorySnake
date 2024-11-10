package com.bombacod.predatorysnake.core.obstacle;

import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private int type;
    private List<Point> points;
    private Matrix matrixMark;

    public Square(int type, int x0, int y0, int x1, int y1, Layers layers) {
        this.type = type;

        points = new ArrayList<>();
        Matrix matrix = layers.getLayer0().getMatrix();
        for (int y = y0; y <= y1; y++) {
            for (int x = x0; x <= x1; x++) {
                points.add(matrix.getPoint(x,y));
            }
        }

        matrixMark = layers.getLayer3().getMatrix();
    }

    public boolean isObstacle(int index){
        return matrixMark.getPoint(index).getType() == type;
    }

    public void process(){
        List<Point> buffer = new ArrayList<>();

        for (Point point : points) {
            point.reset();
            // mark
            matrixMark.getPoint(point.index).setType(type);
        }

    }
}
