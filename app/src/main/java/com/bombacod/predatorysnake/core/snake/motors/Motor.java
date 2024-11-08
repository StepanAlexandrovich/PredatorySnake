package com.bombacod.predatorysnake.core.snake.motors;

import com.bombacod.predatorysnake.core.MatrixObject;
import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.DataSnake;

public class Motor implements MatrixObject {
    private int index;

    private DataSnake data;
    private GeneratorMotor generator;

    public Motor(int index,DataSnake data) {
        this.index = index;
        this.data = data;

        generator = new GeneratorMotor(data);
    }

    // encapsulation
    public Motor setPower(int power) {
        generator.setPower(power);
        return this;
    }

    public Motor setLowerBorder(int hCore) {
        generator.setLowerBorder(hCore);
        return this;
    }

    @Override
    public void start(int x, int y, int value) {
        Point point = data.getMatrixMotors().getPoint(x,y);
        point.setValue(value).setType(data.getTypeMotors(index));
    }

    @Override
    public void process() {
        generator.process(data.getPointsMotor(index));
        UniversalMethods.decrease(data.getPointsMotor(index),-1);
    }
}
