package com.bombacod.predatorysnake.core.snake.head;

import com.bombacod.predatorysnake.core.UniversalMethods;
import com.bombacod.predatorysnake.core.snake.SnakeData;

class Decrease {
    private SnakeData snakeData;

    public Decrease(SnakeData snakeData) {
        this.snakeData = snakeData;
    }

    public void process(){
        for (int i = 0; i < snakeData.getLength(); i++) {
            if(snakeData.isHead(i)){
                UniversalMethods.decrease(snakeData.getPointHead(i),-1);
            }
        }
    }
}
