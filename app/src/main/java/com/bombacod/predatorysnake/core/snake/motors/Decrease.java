package com.bombacod.predatorysnake.core.snake.motors;

import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.snake.SnakeData;

class Decrease {
    private SnakeData snakeData;

    public Decrease(SnakeData snakeData) {
        this.snakeData = snakeData;
    }

    public void process(){
        for (int i = 0; i < snakeData.getLength(); i++) {
            if(snakeData.isMotors(i)){
                UniversalMethods.decrease(snakeData.getPointMotors(i),-1);
            }
        }
    }
}
