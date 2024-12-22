package com.bombacod.predatorysnake.game.core.matrix;

public class Next {
    public final int[] table = {1,0};
    // dynamic
    private int now = 0,next=table[now];

    public void process(){
        next = table[now = table[now]];
    }

    public int now() { return now; }
    public int next() { return next; }
}
