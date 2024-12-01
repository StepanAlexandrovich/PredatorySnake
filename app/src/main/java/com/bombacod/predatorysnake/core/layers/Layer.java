package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.CreatePoint;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Next;
import com.bombacod.predatorysnake.core.types.Types;

public class Layer {
    private Matrix matrix;
    private Types types;
    private CollectionOptimization collectionOptimization; // rename

    public Layer(int width, int height, Next next, CreatePoint createPoint) {
        matrix = new Matrix(width, height, next, createPoint);
        types = new Types();

        collectionOptimization = new CollectionOptimization(matrix);
    }

    public Matrix getMatrix() { return matrix; }
    public Types getTypes() { return types; }

    // optimization
    public CollectionOptimization getCollectionOptimization() { return collectionOptimization; }
}


