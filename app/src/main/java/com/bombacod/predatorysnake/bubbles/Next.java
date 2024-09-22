package com.bombacod.predatorysnake.bubbles;

public class Next {
    public final int[] table = {1,0};
    // dinamic
    public int now = 0,next=table[now];

    public void next(){}

    public void process(){
        next();
        next = table[now = table[now]];
    }
}
