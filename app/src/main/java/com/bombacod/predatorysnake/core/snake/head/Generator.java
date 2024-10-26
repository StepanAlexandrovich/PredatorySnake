package com.bombacod.predatorysnake.core.snake.head;

import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.SnakeData;

class Generator {
    private SnakeData snakeData;
    private int length;

    private int numberOfTypes = 800;
    public int[] massOfType   = new int[numberOfTypes];
    public int[] generation   = new int[numberOfTypes];
    private int power;

    public Generator(SnakeData snakeData) {
        this.snakeData = snakeData;
        this.length = snakeData.getLength();
    }

    // set
    public Generator setPower(int power) {
        this.power = power;
        return this;
    }

    private boolean isCorePoint(int i){
        if(snakeData.isHead(i) && !snakeData.isMotors(i) && snakeData.getPointHead(i).getValue() > 400){
            return true;
        }
        return false;
    }

    public void process(){
        for(int i = 0;i<massOfType.length;i++){
            massOfType[i] = 0;
        }

        for (int i = 0; i < length; i++) {
            if (isCorePoint(i)){
                massOfType[snakeData.getPointHead(i).getType()]++;
            }
        }

        for(int i = 1;i<massOfType.length;i++){
            if(massOfType[i]!=0){
                generation[i] = power/massOfType[i];
            }
        }

        for (int i = 0; i < length; i++) {
            Point pointHead = snakeData.getPointHead(i);

            if(isCorePoint(i)){
                pointHead.addValue(generation[pointHead.getType()]);
            }
        }

    }
}
