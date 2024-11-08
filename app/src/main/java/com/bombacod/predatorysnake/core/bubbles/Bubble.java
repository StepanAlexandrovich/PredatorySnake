package com.bombacod.predatorysnake.core.bubbles;

import com.bombacod.predatorysnake.core.MatrixObject;
import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.layers.Layers;

public class Bubble implements MatrixObject {
    private DataBubble data;
    private GeneratorBubble generator;

    public Bubble(int type, Layers layers) {
        data = new DataBubble(layers,type);

        this.generator = new GeneratorBubble();
    }

    // encapsulation
    public Bubble setPower(int power) {
        generator.setPower(power);
        return this;
    }

    public Bubble setLowerBorder(int hCore) {
        generator.setLowerBorder(hCore);
        return this;
    }

    //
    public boolean isLife(){
        return data.getPoints().size() != 0;
    }

    @Override
    public void start(int x, int y, int value) {
        Point point = data.getMatrix().getPoint(x,y);
        point.setValue(value).setType(data.getType());
    }

    //////////////////////
    @Override
    public void process(){
        generator.process(data.getPoints());
        UniversalMethods.decrease(data.getPoints(),-1);
    }
}
