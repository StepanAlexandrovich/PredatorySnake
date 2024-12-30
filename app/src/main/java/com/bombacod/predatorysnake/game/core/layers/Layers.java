package com.bombacod.predatorysnake.game.core.layers;

public interface Layers {

    int getWidth();
    int getHeight();
    int getLength();
    int getX(int index);
    int getY(int index);

    Layer getLayer0();
    Layer getLayer1();
    Layer getLayer2();
    Layer getLayer3();

    void reset();

    void process();

}
