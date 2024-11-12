package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.Next;
import com.bombacod.predatorysnake.core.matrix.Point;

public class PointIdentityImpl extends Point{
    private int now,next;

    public PointIdentityImpl(int index, int x, int y, Next next) {
        super(index, x, y, next);
    }

    public void process(){
        next = super.next();
        now = super.now();

        value[next] = value[now];
        type[next] = type[now];

        for(Point point:points){
            int sum = 0;

            for(Point point1:points){
                if(point.type[now] == point1.type[now]){
                    sum += point1.value[now];
                }else{
                    sum -= point1.value[now];
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

//    public void process1(int next,int now){
//        value[next] = value[now];
//        type[next] = type[now];
//
//        for(Point point:points){
//            int sum = 0;
//
//            for(Point point1:points){
//                if(point.type[now] == point1.type[now]){
//                    sum += point1.value[now];
//                }else{
//                    sum -= point1.value[now];
//                }
//            }
//
//            if(sum >= 0){
//                this.value[next] = sum/5;
//                this.type[next] = point.type[now];
//                break;
//            }
//        }
//
//        if(value[next]==0){ type[next] = 0; }
//    }
}
