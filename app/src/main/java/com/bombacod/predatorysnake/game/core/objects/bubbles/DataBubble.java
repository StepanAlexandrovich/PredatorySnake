package com.bombacod.predatorysnake.game.core.objects.bubbles;

import com.bombacod.predatorysnake.game.core.matrix.Matrix;
import com.bombacod.predatorysnake.game.core.matrix.Point;
import com.bombacod.predatorysnake.game.core.layers.Layer;

import java.util.List;

class DataBubble {
    private int type;
    private Layer layer;

    public DataBubble(Layer layer, int type) {
        this.type = type;
        this.layer = layer;
    }

    public Matrix getMatrix(){ return layer.getMatrix(); }
    public List<Point> getPoints(){ return layer.getTypes().getType(type).getPoints(); }

    public int getType() { return type; }
}
