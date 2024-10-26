package com.bombacod.predatorysnake.core.snake.head;

import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.SnakeData;

public class Head {
    private SnakeData snakeData;
    private int length;

    private Generator generator;
    private double[] coefficientsImpactMotors;

    private Decrease decrease;

    public Head(SnakeData snakeData) {
        this.snakeData = snakeData;
        this.length = snakeData.getLength();

        generator = new Generator(snakeData).setPower(3000);

        coefficientsImpactMotors = new double[800];

        decrease = new Decrease(snakeData);
    }

    public void start(int x,int y, int value,int type){
        Point point = snakeData.getMatrixHead().getPoint(x, y);

        point.setValue(value);
        point.setType(type);
    }

    public void process(){
        generator.process();

        // impact matrixMotors to matrix
        for(int i = 0; i < length; i++){
            Point point = snakeData.getPointHead(i);
            Point pointMotors = snakeData.getPointMotors(i);

            if(snakeData.isHead(i) && snakeData.isMotors(i)){
                int impact = (int)(pointMotors.getValue() * coefficientsImpactMotors[pointMotors.getType()]);
                point.addValue(-impact);
                if(point.getValue()<0){
                    point.reset();
                }
            }
        }

        decrease.process();
    }

    public void directly(){
        coefficientsImpactMotors[snakeData.getTypeMotor1()] = 1.0;
        coefficientsImpactMotors[snakeData.getTypeMotor2()] = 1.0;
    }

    public void right(){
        coefficientsImpactMotors[snakeData.getTypeMotor1()] = 1.5;
        coefficientsImpactMotors[snakeData.getTypeMotor2()] = 0.3;
    }

    public void left(){
        coefficientsImpactMotors[snakeData.getTypeMotor1()] = 0.3;
        coefficientsImpactMotors[snakeData.getTypeMotor2()] = 1.5;
    }

}
