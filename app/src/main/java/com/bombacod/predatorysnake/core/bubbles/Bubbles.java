package com.bombacod.predatorysnake.core.bubbles;

import com.bombacod.predatorysnake.core.layers.Layer;
import com.bombacod.predatorysnake.core.layers.Layers;

public class Bubbles {
    private Layer layer;
    private Bubble[] bubbles;

    private int number;

    public Bubbles(Layers layers) {
        layer = layers.getLayer0();

        bubbles = new Bubble[20]; // remake
    }

    public int getNumber() {
        return number;
    }

    public Bubble addBubble(int type){
        Bubble bubble = new Bubble(type, layer).setPower(2000).setLowerBorder(400);
        return bubbles[type] = bubble;
    }

    public void deleteBubble(int type){
        bubbles[type] = null;
    }

    public void start(int x, int y, int value, int type){
        Bubble bubble = addBubble(type);
        bubble.start(x,y,value);
    }

    public void startMatrix(int xBase,int yBase,int startType,int side,int multiplication){
        int type = startType;
        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                start(xBase + x*multiplication,yBase + y*multiplication,5000,type);
                type++;
            }
        }
    }

    ////////////////////////
    public void process(){
        int number = 0;
        for (int i = 0; i < bubbles.length; i++) {
            Bubble bubble = bubbles[i];

            if(bubble != null && !bubble.isLife()){
                bubbles[i] = bubble = null;
            }

            if(bubble != null){
                bubble.process();
                number++;
            }
        }

        this.number = number;
    }

}
