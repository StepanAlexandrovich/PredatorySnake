package com.bombacod.predatorysnake;

public class Model {
    private  int value = 0;
    private int vector = 1;

    public int getValue() {
        return value;
    }

    public void left(){
        vector = -1;
    }

    public void right(){
        vector = 1;
    }

    public void process(){
        value += vector;
    }
}
