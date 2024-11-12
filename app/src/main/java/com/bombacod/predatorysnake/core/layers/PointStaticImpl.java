package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.Next;
import com.bombacod.predatorysnake.core.matrix.Point;

public class PointStaticImpl extends Point {

    public PointStaticImpl(int index, int x, int y, Next next) {
        super(index, x, y, next);
    }

    public void process() {
        for (Point point : points) {
            point.reset();
        }
    }
}
