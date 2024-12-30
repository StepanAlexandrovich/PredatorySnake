package com.bombacod.predatorysnake.game.core;

import com.bombacod.predatorysnake.game.core.interfaces.IsLife;
import com.bombacod.predatorysnake.game.core.interfaces.PointsFunctions;
import com.bombacod.predatorysnake.game.core.interfaces.Start;
import com.bombacod.predatorysnake.game.core.layers.Layer;
import com.bombacod.predatorysnake.game.core.matrix.Matrix;
import com.bombacod.predatorysnake.game.core.matrix.Point;
import com.bombacod.predatorysnake.game.core.types.DataType;

import java.util.List;

public abstract class MatrixObjectStandard implements PointsFunctions, IsLife, Start {
    public final int type;
    private DataType dataType;

    private Matrix matrix;

    public MatrixObjectStandard(int type, Layer layer) {
        this.type = type;
        dataType = layer.getTypes().getType(type);

        matrix = layer.getMatrix();
    }

    @Override
    public Matrix getMatrix() { return matrix; }

    @Override
    public Point getPoint(int index) {
        Point point = matrix.getPoint(index);
        if(point.getType() == getType()){ return point; }
        return null;
    }

    @Override
    public boolean isExisting(int index) {
        Point point = matrix.getPoint(index);
        if(point.getType() == getType()){ return true; }
        return false;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public boolean isLife() { return getPoints().size() != 0; }

    @Override
    public List<Point> getPoints() {
        return dataType.getPoints();
    }

    @Override
    public void start(int x, int y, int value){
        Point point = matrix.getPoint(x, y);
        point.setValue(value).setType(type);
    }
}
