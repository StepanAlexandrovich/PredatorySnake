package com.bombacod.predatorysnake.core.bubbles;

import com.bombacod.predatorysnake.core.matrix.Point;

public class PointImpl extends Point {
    public void heart(){
        value[next] = value[now];
        type[next] = type[now];

        for(Point point:points){
            int sum = 0;

            for(Point point1:points){
                if(point.type[now] == point1.type[now]){
                    sum += point1.value[now];
                }else{
                    sum += -point1.value[now];
                }
            }

            int nextThisValue = sum/5;
            if(nextThisValue>0){
                this.value[next] = nextThisValue;
                this.type[next] = point.type[now];
                break;
            }
        }

        if(value[next]==0){ type[next] = 0; }
    }

    // переделать
    private void decrease(){
        if(type[next]==0&&value[next]>000){
            value[next]--;
        }else
        if(value[next]>510){ value[next]--; }

    }

    @Override
    public void process(){
        heart();
        decrease();
    }

}
