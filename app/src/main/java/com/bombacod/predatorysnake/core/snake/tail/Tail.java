package com.bombacod.predatorysnake.core.snake.tail;

import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.SnakeData;

public class Tail {
    private SnakeData snakeData;

    public Tail(SnakeData snakeData) {
        this.snakeData = snakeData;
    }

    public void process(){
        // impact
        for(int i = 0; i < snakeData.getLength(); i++){
            Point point = snakeData.getPointTail(i);

            if(snakeData.isHead(i)){
                point.reset();
            }

            if(snakeData.isMotors(i)){
                point.reset();
            }
        }

    }
}
