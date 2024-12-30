package com.bombacod.predatorysnake.game.core.objects.bubbles;

import com.bombacod.predatorysnake.game.core.MatrixObjectStandard;
import com.bombacod.predatorysnake.game.core.UniversalMethods;
import com.bombacod.predatorysnake.game.core.layers.Layer;

public class Bubble extends MatrixObjectStandard {
    private GeneratorBubble generator;

    public Bubble(int type, Layer layer) {
        super(type,layer);

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

    //////////////////////
    public void process(){
        generator.process(getPoints());
        UniversalMethods.decrease(getPoints(),-2);
    }

}
