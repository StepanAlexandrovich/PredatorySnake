package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.Next;
import com.bombacod.predatorysnake.core.matrix.Point;

public class PointTrackImpl extends Point {
    private int now,next;

    public PointTrackImpl(int index, int x, int y, Next next) {
        super(index, x, y, next);
    }

    private int average(){
        int difference = 0;
        for (Point point : points) {
            difference += point.value[now] - value[now];
        }

        return value[now] + difference/5;
    }

    private int up(int value){
        if(value > 0 && value < 200){
            return value + 1;
        }
        return value;
    }


    public void process() {
        next = super.next();
        now = super.now();

        value[next] = average();
        value[next] = up(value[next]);
    }

}
