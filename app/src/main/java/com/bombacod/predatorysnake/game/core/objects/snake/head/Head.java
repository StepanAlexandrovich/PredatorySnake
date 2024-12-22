package com.bombacod.predatorysnake.game.core.objects.snake.head;

import com.bombacod.predatorysnake.pf.Direction;
import com.bombacod.predatorysnake.game.core.MatrixObjectStandard;
import com.bombacod.predatorysnake.game.core.UniversalMethods;
import com.bombacod.predatorysnake.game.core.layers.Layer;

public class Head extends MatrixObjectStandard {
    private GeneratorHead generator;
    private Control control;

    private int direction;

    public Head(int type, Layer layer) {
        super(type,layer);

        generator = new GeneratorHead();
        control = new Control();
    }

    public int getDirection() { return direction; }

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
    public Head setCoefficientMax(double coefficientMax) {
        control.setCoefficientMax(coefficientMax);
        return this;
    }

    public Head setCoefficientMin(double coefficientMin) {
        control.setCoefficientMin(coefficientMin);
        return this;
    }

    public void directly(){
        control.directly();
        direction = Direction.DIRECTLY;
    }
    public void right(){
        control.right();
        direction = Direction.RIGHT;
    }
    public void left(){
        control.left();
        direction = Direction.LEFT;
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
