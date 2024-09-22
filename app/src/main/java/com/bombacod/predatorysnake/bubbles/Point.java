package com.bombacod.predatorysnake.bubbles;

public class Point extends Next{
    // final
    public int x,y;
    public Point[] points = new Point[5]; // 0 - in place; 1 - right; 2 - down; 3 - left; 4 - up;
    // dynamic
    private int[] value = new int[2];
    private int[] type = new int[2];

    //// getSet ////
    public int getValue()   { return value[now]; }
    public void setValue(int v) { value[now]  = v; }
    public void addValue(int v) {
        value[now] += v;
        if(value[now]<0){ value[now] = 0; }
    }

    public int getType()   { return type[now]; }
    public void setType(int v){ type[now] = v; }


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

    private void decrease(){
        if(type[next]==0&&value[next]>000){
            value[next]--;
        }else
        if(value[next]>510){ value[next]--; }

    }

    @Override
    public void next(){
        heart();
        decrease();
    }
}
