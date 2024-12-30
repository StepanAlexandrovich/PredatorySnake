package com.bombacod.predatorysnake.game.core.objects.obstacles;

import com.bombacod.predatorysnake.game.core.interfaces.IsExisting;
import com.bombacod.predatorysnake.game.core.layers.Layers;
import com.bombacod.predatorysnake.game.core.matrix.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Obstacles implements IsExisting {
    private int mark;
    private Matrix matrixMark,matrixHead,matrixMotors;

    private List<Coordinate> coordinates;

    public Obstacles(int mark, Layers layers) {
        this.mark = mark;

        matrixMark = layers.getLayer3().getMatrix();  // rename matrix
        matrixHead = layers.getLayer0().getMatrix();
        matrixMotors = layers.getLayer1().getMatrix();

        coordinates = new ArrayList<>();
    }

    public void reset(){
        coordinates.clear();
    }

    public Obstacles addCoordinates(List<Coordinate> coordinates){
        this.coordinates.addAll(coordinates);
        return this;
    }

    @Override
    public boolean isExisting(int index) {
        return matrixMark.getPoint(index).getMark() == mark;
    }

    public void process(){
        for (Coordinate coordinate : coordinates) {
            int index = matrixMark.getPoint(coordinate.x,coordinate.y).index;

            matrixHead.getPoint(index).reset();
            matrixMotors.getPoint(index).reset();
            matrixMark.getPoint(index).setMark(1);
        }
    }

}
