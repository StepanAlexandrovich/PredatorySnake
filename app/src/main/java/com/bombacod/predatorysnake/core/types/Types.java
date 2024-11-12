package com.bombacod.predatorysnake.core.types;

import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

public class Types {
    private Matrix matrix;
    private DataType[] dataTypes;

    public Types(Matrix matrix) {
        this.matrix = matrix;

        dataTypes = new DataType[20];
        for (int i = 0; i < dataTypes.length; i++) {
            dataTypes[i] = new DataType(i);
        }
    }

    ////////////
    public DataType getType(int index){
        return dataTypes[index];
    }
    public Matrix getMatrix() { return matrix; }

    public void update(){
        reset();

        for (Point point : matrix.getPoints()) {
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
