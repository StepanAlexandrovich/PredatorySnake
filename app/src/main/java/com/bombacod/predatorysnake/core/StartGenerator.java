package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.core.objects.bubbles.Bubbles;
import com.bombacod.predatorysnake.core.objects.obstacles.Figures;
import com.bombacod.predatorysnake.core.objects.obstacles.Obstacles;
import com.bombacod.predatorysnake.core.objects.snake.Snake;

public class StartGenerator {
    private int width,height,xCenter,yCenter;
    private int bubblesValue = 5000;
    private int snakeValue = 10000;
    private Figures figures = new Figures();

    public StartGenerator(int width, int height) {
        this.width = width;
        this.height = height;

        xCenter = width/2;
        yCenter = height/2;
    }

    public StartGenerator setCenterCoordinate(int xCenter, int yCenter){
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        return this;
    }

    public void start(int levelIndex, Bubbles bubbles, Snake snake, Obstacles obstacles){
        switch (levelIndex){
            case 1: startLevel1(bubbles,snake,obstacles); break;
            case 2: startLevel2(bubbles,snake,obstacles); break;
            case 3: startLevel3(bubbles,snake,obstacles); break;
            case 4: startLevel4(bubbles,snake,obstacles); break;
        }
    }

    private void startLevel1(Bubbles bubbles, Snake snake,Obstacles obstacles){
        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1,bubblesValue,3);
        obstacles.setCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel2(Bubbles bubbles, Snake snake,Obstacles obstacles){
        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1 - 2,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1 - 2,bubblesValue,3);
        bubbles.start(xCenter + 0,yCenter + 1 + 1,bubblesValue,4);
        obstacles.setCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel3(Bubbles bubbles, Snake snake,Obstacles obstacles){
        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);
        obstacles.setCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel4(Bubbles bubbles, Snake snake,Obstacles obstacles){
        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        //bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        obstacles.addCoordinates(figures.up(40,60,30));
        obstacles.addCoordinates(figures.up(70,60,30));
        obstacles.addCoordinates(figures.left(70,60,30));
        //obstacles.addCoordinates(figures.up(40,20,10));
    }

}
