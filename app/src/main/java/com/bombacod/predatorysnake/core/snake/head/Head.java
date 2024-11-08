package com.bombacod.predatorysnake.core.snake.head;

import com.bombacod.predatorysnake.core.MatrixObject;
import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.DataSnake;

public class Head implements MatrixObject {
    private DataSnake data;

    private GeneratorHead generator;
    private Control control;

    public Head(DataSnake data) {
        this.data = data;

        generator = new GeneratorHead(data);
        control = new Control(data);
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
    @Override
    public void start(int x, int y, int value){
        Point point = data.getMatrixHead().getPoint(x, y);
        point.setValue(value).setType(data.getTypeHead());
    }

    @Override
    public void process(){
        if(data.isLifeMotor0() && data.isLifeMotor1()){
            generator.process(data.getPointsHead());
        }

        control.process(data.getPointsHead());

        UniversalMethods.decrease(data.getPointsHead(),-1);
    }

}
