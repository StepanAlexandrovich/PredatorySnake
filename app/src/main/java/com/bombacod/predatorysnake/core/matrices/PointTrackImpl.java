package com.bombacod.predatorysnake.core.matrices;

import com.bombacod.predatorysnake.core.matrix.Point;

public class PointTrackImpl extends Point {

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

    @Override
    public void process() {
        value[next] = average();
        value[next] = up(value[next]);
    }
}
