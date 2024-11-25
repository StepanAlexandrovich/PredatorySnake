package com.bombacod.predatorysnake.core.objects.snake.body;

import com.bombacod.predatorysnake.core.interfaces.IsExisting;
import com.bombacod.predatorysnake.core.layers.Layer;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

public class Body {
    private Matrix matrix;

    public Body(Layer layer) {
        matrix = layer.getMatrix();
    }

    public void process(IsExisting motor0, IsExisting motor1){
        for (Point point : matrix.getPoints()) {
            int index = point.index;

            if(motor0.isExisting(index) || motor1.isExisting(index)){
                point.setValue(0).setType(0);
            }
        }
    }

}
