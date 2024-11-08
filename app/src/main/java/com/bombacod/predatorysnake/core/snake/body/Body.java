package com.bombacod.predatorysnake.core.snake.body;

import com.bombacod.predatorysnake.core.MatrixObject;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.DataSnake;

public class Body implements MatrixObject {
    private DataSnake data;

    public Body(DataSnake data) {
        this.data = data;
    }

    @Override
    public void start(int x, int y, int value) {}

    public void process(){
        for (Point point : data.getPointsBody()) {
            int index = point.index;

            if(data.isHead(index) || data.isMotors(index)){
                point.reset();
            }
        }
    }
}
