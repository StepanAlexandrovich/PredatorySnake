package com.bombacod.predatorysnake.core.matrix;

public abstract class Point extends Next{
    public final int index,x,y;
    public final Point[] points = new Point[5]; // 0 - in place; 1 - right; 2 - down; 3 - left; 4 - up;

    // dynamic
    public final int[] value = new int[2];
    public final int[] type = new int[2];

    public Point(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    //// get set ////
    public int getValue()   { return value[now]; }
    public int getType()   { return type[now]; }

    public Point setValue(int v) {
        value[now]  = v;
        return this;
    }
    public Point setType(int v){
        type[now] = v;
        return this;
    }

    public void addValue(int v) {
        value[now] += v;
    }

    public void reset(){
        value[now] = 0;
        type[now] = 0;
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
