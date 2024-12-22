package com.bombacod.predatorysnake.game.core.objects.snake.body;

import com.bombacod.predatorysnake.game.core.interfaces.IsExisting;
import com.bombacod.predatorysnake.game.core.layers.Layer;
import com.bombacod.predatorysnake.game.core.matrix.Matrix;
import com.bombacod.predatorysnake.game.core.matrix.Point;

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
