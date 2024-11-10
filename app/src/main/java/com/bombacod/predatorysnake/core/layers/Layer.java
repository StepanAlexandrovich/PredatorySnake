package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.CreatePoint;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.types.Types;

public class Layer {
    private Matrix matrix;
    private Types types;

    public Layer(int width, int height, CreatePoint createPoint) {
        matrix = new Matrix(width, height, createPoint);
        types = new Types(matrix);
    }

    public Matrix getMatrix() { return matrix; }
    public Types getTypes() { return types; }
}


