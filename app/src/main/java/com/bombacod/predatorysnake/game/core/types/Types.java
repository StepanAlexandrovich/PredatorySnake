package com.bombacod.predatorysnake.game.core.types;

import com.bombacod.predatorysnake.game.core.matrix.Matrix;
import com.bombacod.predatorysnake.game.core.matrix.Point;

import java.util.List;

public class Types {
    private DataType[] dataTypes;

    public Types() {
        dataTypes = new DataType[20];
        for (int i = 0; i < dataTypes.length; i++) {
            dataTypes[i] = new DataType(i);
        }
    }

    ////////////
    public DataType getType(int index){
        return dataTypes[index];
    }

    public void update(Matrix matrix){
        reset();

        for (Point point : matrix.getPoints()) {
            if(point.getType()!=0){
                dataTypes[point.getType()].addPoint(point);
            }
        }
    }

    public void update(List<Point> points){
        reset();

        for (Point point : points) {
            if(point.getType()!=0){
                dataTypes[point.getType()].addPoint(point);
            }
        }
    }

    // delete
    public void reset(){
        for (DataType type : dataTypes) {
            type.reset();
        }
    }

}
