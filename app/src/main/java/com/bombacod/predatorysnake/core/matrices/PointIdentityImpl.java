package com.bombacod.predatorysnake.core.matrices;

import com.bombacod.predatorysnake.core.matrix.Point;

public class PointIdentityImpl extends Point {

    @Override
    public void process(){
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

            if(sum >= 0){
                this.value[next] = sum/5;
                this.type[next] = point.type[now];
                break;
            }
        }

        if(value[next]==0){ type[next] = 0; }
    }

}
