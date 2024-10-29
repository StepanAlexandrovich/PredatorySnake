package com.bombacod.predatorysnake.core.snake.motors;

import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.SnakeData;
import com.bombacod.predatorysnake.core.matrices.Matrices;

public class Motors {
    private int length;

    private Matrices matrices;
    private SnakeData snakeData;

    private Matrix matrix;

    private Generator generator;
    private Decrease decrease;

    public Motors(SnakeData snakeData) {
        this.matrices = snakeData.getMatrices();
        this.snakeData = snakeData;
        this.length = snakeData.getLength();

        this.matrix = matrices.getMatrixIdentity1();
        generator = new Generator(snakeData).setPower(500);
        decrease = new Decrease(snakeData);
    }

    public void start(int x,int y, int value,int type){
        Point point = snakeData.getMatrixMotors().getPoint(x,y);
        point.setType(type);
        point.setValue(value);
    }

    public void process(){
        generator.process();
        decrease.process();
    }
}
