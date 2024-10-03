package com.bombacod.predatorysnake.matrix;

public abstract class Next {
    public final int[] table = {1,0};
    // dynamic
    public int now = 0,next=table[now];

    public abstract void next();

    public void process(){
        next();
        next = table[now = table[now]];
    }
}
