package com.bombacod.predatorysnake.core.objects.bubbles;

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

    public void startFour(int xCenter,int yCenter,int startType,int side,int value){
        start(xCenter - side,yCenter - side - 1,value,startType + 0);
        start(xCenter + side + 1,yCenter - side,value,startType + 1);
        start(xCenter + side,yCenter + side + 1,value,startType + 2);
        start(xCenter - side - 1,yCenter + side,value,startType + 3);
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
