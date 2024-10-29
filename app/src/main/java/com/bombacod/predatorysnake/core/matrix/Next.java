package com.bombacod.predatorysnake.core.matrix;

public abstract class Next {
    public final int[] table = {1,0};
    // dynamic
    public int now = 0,next=table[now];

    public abstract void process();

    public void next(){
        next = table[now = table[now]];
    }

    public void processNext(){
        process();
        next();
    }

}
