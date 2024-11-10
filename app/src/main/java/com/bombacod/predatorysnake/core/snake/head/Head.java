package com.bombacod.predatorysnake.core.snake.head;

import com.bombacod.predatorysnake.core.MatrixObjectStandard;
import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.layers.Layer;

public class Head extends MatrixObjectStandard {
    private GeneratorHead generator;
    private Control control;

    public Head(int type, Layer layer) {
        super(type,layer);

        generator = new GeneratorHead();
        control = new Control();
    }

    // encapsulation generator
    public Head setPower(int power) {
        generator.setPower(power);
        return this;
    }

    public Head setLowerBorder(int hCore) {
        generator.setLowerBorder(hCore);
        return this;
    }

    // encapsulation control
    public void directly(){
        control.directly();
    }
    public void right(){
        control.right();
    }
    public void left(){
        control.left();
    }

    //////////////////////////
    public void process(MatrixObjectStandard object0, MatrixObjectStandard object1){
        if(object0.isLife() && object1.isLife()){
            generator.process(getPoints(),object0,object1);
        }

        control.process(getPoints(),object0,object1);
        UniversalMethods.decrease(getPoints(),-1);
    }

}
