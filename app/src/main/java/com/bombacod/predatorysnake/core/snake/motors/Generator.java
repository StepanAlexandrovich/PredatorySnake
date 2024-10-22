package com.bombacod.predatorysnake.core.snake.motors;

import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.SnakeData;

class Generator {
    private SnakeData snakeData;
    private int length;

    private int numberOfTypes = 800;
    private int[] massOfType   = new int[numberOfTypes];
    private int[] generation   = new int[numberOfTypes];
    private int power;

    private boolean isCorePoint(int i){
        if(snakeData.isMotors(i) && snakeData.isHead(i) && snakeData.getPointMotors(i).getValue() > 20){
            return true;
        }
        return false;
    }

    Generator(SnakeData snakeData){
        this.snakeData = snakeData;
        this.length = snakeData.getLength();
    }

    public Generator setPower(int power) {
        this.power = power;
        return this;
    }

    public void process(){
        for(int i = 0;i<massOfType.length;i++){
            massOfType[i] = 0;
        }

        for(int i = 0; i < length; i++){
            Point pointMotors = snakeData.getPointMotors(i);

            if(isCorePoint(i)){
                massOfType[pointMotors.getType()] += 1;
            }
        }

        for(int i = 1;i<massOfType.length;i++){
            if(massOfType[i]!=0){
                generation[i] = power/massOfType[i];
            }
        }

        for(int i = 0; i < length; i++){
            Point pointMotors = snakeData.getPointMotors(i);

            if(isCorePoint(i)){
                pointMotors.addValue(generation[pointMotors.getType()]);
            }
        }

    }
}
