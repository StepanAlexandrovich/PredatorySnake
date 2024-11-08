package com.bombacod.predatorysnake.core.snake.motors;

import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.snake.DataSnake;

class Decrease {
    private DataSnake data;

    public Decrease(DataSnake data) {
        this.data = data;
    }

    public void process(){
        for (int i = 0; i < data.getLength(); i++) {
            if(data.isMotors(i)){
                UniversalMethods.decrease(data.getPointMotors(i),-1);
            }
        }
    }
}
