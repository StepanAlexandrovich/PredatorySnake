package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.Point;

public class PointStaticImpl extends Point {
    public PointStaticImpl(int index, int x, int y) {
        super(index, x, y);
    }

    @Override
    public void process() {
        for (Point point : points) {
            point.reset();
        }
    }
}
