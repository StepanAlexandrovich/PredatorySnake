package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.core.objects.bubbles.Bubbles;
import com.bombacod.predatorysnake.core.objects.snake.Snake;

public class StartGenerator {
    private int xCenter,yCenter;

    private int bubblesValue = 5000;
    private int snakeValue = 10000;

    public StartGenerator setCenterCoordinate(int xCenter,int yCenter){
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        return this;
    }

    public void start(int levelIndex, Bubbles bubbles, Snake snake){
        switch (levelIndex){
            case 1: startLevel1(bubbles,snake); break;
            case 2: startLevel2(bubbles,snake); break;
            case 3: startLevel3(bubbles,snake); break;
            case 4: startLevel4(bubbles,snake); break;
        }
    }

    private void startLevel1(Bubbles bubbles, Snake snake){
        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter,yCenter,bubblesValue,2);
    }

    private void startLevel2(Bubbles bubbles, Snake snake){
        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1,bubblesValue,3);
    }

    private void startLevel3(Bubbles bubbles, Snake snake){
        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1 - 2,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1 - 2,bubblesValue,3);
        bubbles.start(xCenter + 0,yCenter + 1 + 1,bubblesValue,4);
    }

    private void startLevel4(Bubbles bubbles, Snake snake){
        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);
    }

}
