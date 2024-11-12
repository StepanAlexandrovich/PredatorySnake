package com.bombacod.predatorysnake.core.matrix;

public abstract class Point {
    public final int index,x,y;
    public final Point[] points = new Point[5]; // 0 - in place; 1 - right; 2 - down; 3 - left; 4 - up;

    private Next next;
    // dynamic
    public final int[] value = new int[2];
    public final int[] type = new int[2];

    public boolean b,b1;

    public Point(int index, int x, int y,Next next) {
        this.index = index;
        this.x = x;
        this.y = y;

        this.next = next;
    }

    // encapsulation next
    public int now(){ return next.now(); }
    public int next(){ return next.next(); }

    //// get set ////
    public int getValue()   { return value[now()]; }
    public int getType()   { return type[now()]; }

    public Point setValue(int v) {
        value[now()]  = v;
        return this;
    }
    public Point setType(int v){
        type[now()] = v;
        return this;
    }

    public void addValue(int v) {
        value[now()] += v;
    }

    public void reset(){
        value[now()] = 0;
        type[now()] = 0;
    }

    public void resetExtra(){
        value[0] = 0;
        value[1] = 0;
        type[0] = 0;
        type[1] = 0;
    }

    public abstract void process();

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
