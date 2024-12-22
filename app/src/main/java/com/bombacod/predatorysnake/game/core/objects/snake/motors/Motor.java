package com.bombacod.predatorysnake.game.core.objects.snake.motors;

import com.bombacod.predatorysnake.game.core.MatrixObjectStandard;
import com.bombacod.predatorysnake.game.core.UniversalMethods;
import com.bombacod.predatorysnake.game.core.interfaces.IsExisting;
import com.bombacod.predatorysnake.game.core.layers.Layer;

public class Motor extends MatrixObjectStandard {
    private GeneratorMotor generator;

    public Motor(int type, Layer layer) {
        super(type,layer);

        generator = new GeneratorMotor();
    }

    // encapsulation generator
    public Motor setPower(int power) {
        generator.setPower(power);
        return this;
    }

    public Motor setLowerBorder(int hCore) {
        generator.setLowerBorder(hCore);
        return this;
    }

    public void process(IsExisting object) {
        generator.process(getPoints(),object);
        UniversalMethods.decrease(getPoints(),-1);
    }

}
