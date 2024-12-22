package com.bombacod.predatorysnake.game.core.objects.snake.head;

import com.bombacod.predatorysnake.game.core.layers.Layer;
import com.bombacod.predatorysnake.game.core.matrix.Point;
import com.bombacod.predatorysnake.game.core.types.DataType;

import java.util.List;

public class HeadEating extends Head {
    private int type;
    private Layer layer;

    public HeadEating(int type, Layer layer) {
        super(type,layer);

        this.type = super.type;
        this.layer = layer;

    }

    // type
    public void setType(int type) { this.type = type; }
    public void restoreType(){ type = super.type; }

    // encapsulation layer
    private DataType getDataType(){ return layer.getTypes().getType(type); }

    @Override
    public List<Point> getPoints() { return getDataType().getPoints(); }

    @Override
    public int getType(){ return type; }
}
