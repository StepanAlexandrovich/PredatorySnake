package com.bombacod.predatorysnake.core.matrix;

public abstract class Point extends Next{
    // do it final
    public int x,y,index;
    public Point[] points = new Point[5]; // 0 - in place; 1 - right; 2 - down; 3 - left; 4 - up;

    // dynamic
    public int[] value = new int[2];
    public int[] type = new int[2];

    //// getSet ////
    public int getValue()   { return value[now]; }
    public void setValue(int v) { value[now]  = v; }
    public void setValueNext(int v) { value[next]  = v; }

    public int getType()   { return type[now]; }
    public void setType(int v){ type[now] = v; }

    public void addValue(int v) {
        value[now] += v;
    }
    public void addValueNext(int v) {
        value[next] += v;
    }

    public int getIndex() {
        return index;
    }

    public void reset(){
        value[now] = 0;
        type[now] = 0;
    }

    public void resetNext(){
        value[next] = 0;
        type[next] = 0;
    }

    // change vector
    public static int right(int vector){
        if(++vector == 5){ vector = 1; }
        return vector;
    }
    public static int left(int vector){
        if(--vector == 0){ vector = 4; }
        return vector;
    }

}
