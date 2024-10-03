package com.bombacod.predatorysnake.matrix;

public abstract class Point extends Next{
    // final
    public int x,y;
    public Point[] points = new Point[5]; // 0 - in place; 1 - right; 2 - down; 3 - left; 4 - up;

    // dynamic
    public int[] value = new int[2];
    public int[] type = new int[2];

    //// getSet ////
    public int getValue()   { return value[now]; }
    public void setValue(int v) { value[now]  = v; }

    public int getType()   { return type[now]; }
    public void setType(int v){ type[now] = v; }

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
