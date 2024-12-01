package com.bombacod.predatorysnake.core.matrix;

public abstract class Point {
    public final int index,x,y;
    public final Point[] points = new Point[5]; // 0 - in place; 1 - right; 2 - down; 3 - left; 4 - up;

    private Next next;
    // dynamic
    public final int[] value = new int[2];
    public final int[] type = new int[2];
    private int mark;

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
    public int getMark() { return mark; }

    public Point setValue(int v) {
        value[now()]  = v;
        return this;
    }
    public Point setValueDouble(int v) {
        value[0]  = v;
        value[1]  = v;
        return this;
    }
    public Point setType(int v){
        type[now()] = v;
        return this;
    }
    public Point setTypeDouble(int v){
        type[0] = v;
        type[1] = v;
        return this;
    }

    public Point setMark(int mark) {
        this.mark = mark;
        return this;
    }

    public void reset(){
        setValue(0).setType(0);
    }

    public void addValue(int v) {
        value[now()] += v;
    }

    public void process(){};

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
