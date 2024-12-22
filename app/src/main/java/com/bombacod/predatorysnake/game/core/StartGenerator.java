package com.bombacod.predatorysnake.game.core;

import com.bombacod.predatorysnake.game.core.objects.bubbles.Bubbles;
import com.bombacod.predatorysnake.game.core.objects.obstacles.Figures;
import com.bombacod.predatorysnake.game.core.objects.obstacles.Obstacles;
import com.bombacod.predatorysnake.game.core.objects.snake.Snake;

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

    public void start(int levelIndex, Bubbles bubbles, Snake snake, Obstacles obstacles,CalculationGameState calculationGameState){
        switch (levelIndex){
            case 1: startLevel1(bubbles,snake,obstacles,calculationGameState); break;
            case 2: startLevel2(bubbles,snake,obstacles,calculationGameState); break;
            case 3: startLevel3(bubbles,snake,obstacles,calculationGameState); break;
            case 4: startLevel4(bubbles,snake,obstacles,calculationGameState); break;
            case 5: startLevel5(bubbles,snake,obstacles,calculationGameState); break;
            case 6: startLevel6(bubbles,snake,obstacles,calculationGameState); break;
            case 7: startLevel7(bubbles,snake,obstacles,calculationGameState); break;
            case 8: startLevel8(bubbles,snake,obstacles,calculationGameState); break;
            case 9: startLevel9(bubbles,snake,obstacles,calculationGameState); break;
            case 10: startLevel10(bubbles,snake,obstacles,calculationGameState); break;
            case 11: startLevel11(bubbles,snake,obstacles,calculationGameState); break;
            case 12: startLevel12(bubbles,snake,obstacles,calculationGameState); break;
            case 13: startLevel13(bubbles,snake,obstacles,calculationGameState); break;
            case 14: startLevel14(bubbles,snake,obstacles,calculationGameState); break;
            case 15: startLevel15(bubbles,snake,obstacles,calculationGameState); break;
            case 16: startLevel16(bubbles,snake,obstacles,calculationGameState); break;
            case 17: startLevel17(bubbles,snake,obstacles,calculationGameState); break;
            case 18: startLevel18(bubbles,snake,obstacles,calculationGameState); break;
            case 19: startLevel19(bubbles,snake,obstacles,calculationGameState); break;
            case 20: startLevel20(bubbles,snake,obstacles,calculationGameState); break;
            case 21: startLevel21(bubbles,snake,obstacles,calculationGameState); break;
        }
    }

    private void startLevel1(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1,bubblesValue,3);
        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel2(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1 - 2,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1 - 2,bubblesValue,3);
        bubbles.start(xCenter + 0,yCenter + 1 + 1,bubblesValue,4);
        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel3(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);
        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel4(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        obstacles.addCoordinates(figures.up(55,72,54));
        obstacles.addCoordinates(figures.up(54,60,30));
        obstacles.addCoordinates(figures.up(56,60,30));
        obstacles.addCoordinates(figures.left(85,45,60));
        obstacles.addCoordinates(figures.left(70,44,30));
        obstacles.addCoordinates(figures.left(70,46,30));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel5(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        int side = 5;

        snake.start(+12 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        int r = 36;
        int d = r * 2;
        int s = d - 10;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,d));
        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter - r,d));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,d));
        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter + r,s));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    // time+
    private void startLevel6(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(650);

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1,bubblesValue,3);
        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel7(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(1100);

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1 - 2,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1 - 2,bubblesValue,3);
        bubbles.start(xCenter + 0,yCenter + 1 + 1,bubblesValue,4);
        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel8(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(1300);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);
        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel9(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(1600);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        obstacles.addCoordinates(figures.up(55,72,54));
        obstacles.addCoordinates(figures.up(54,60,30));
        obstacles.addCoordinates(figures.up(56,60,30));
        obstacles.addCoordinates(figures.left(85,45,60));
        obstacles.addCoordinates(figures.left(70,44,30));
        obstacles.addCoordinates(figures.left(70,46,30));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel10(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(1300);

        int side = 5;

        snake.start(+12 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        int r = 36;
        int d = r * 2;
        int s = d - 10;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,d));
        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter - r,d));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,d));
        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter + r,s));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel11(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - 3,yCenter - 1 - 2,bubblesValue,2);
        bubbles.start(xCenter + 3,yCenter + 1 - 2,bubblesValue,3);
        bubbles.start(xCenter + 0,yCenter + 1 + 1,bubblesValue,4);

        int r = 33;
        int d = r * 2;
        int s = d - 10;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,d));
        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter - r,d));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,s));
        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter + r,d));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel12(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(1200);

        int side = 5;

        snake.start(+12 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 3,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side + 3,bubblesValue,5);

        int r = 20;
        int d = r * 2;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,d));
        obstacles.addCoordinates(figures.down(xCenter + 1 ,yCenter - r,d));
        obstacles.addCoordinates(figures.down(xCenter + 0 ,0,66));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,d));
        obstacles.addCoordinates(figures.up(xCenter - 1 ,yCenter + r,d));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel13(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        int side = 5;

        snake.start(+12 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        int r = 12;
        int d = r * 2;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,d));
        obstacles.addCoordinates(figures.down(xCenter + 1 ,yCenter - r,d));
        obstacles.addCoordinates(figures.down(xCenter + 0 ,0,66));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,d));
        obstacles.addCoordinates(figures.up(xCenter - 1 ,yCenter + r,d));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel14(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

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

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel15(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        obstacles.addCoordinates(figures.up(40,60,30));
        obstacles.addCoordinates(figures.up(70,60,30));
        obstacles.addCoordinates(figures.left(70,60,30));
        //obstacles.addCoordinates(figures.up(40,20,10));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    // ******************
    private void startLevel16(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(1100);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        int r = 20;
        int d = r * 2;
        int s = d - 10;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,s));
        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter - r,s));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,s));
        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter + r,s));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel17(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        int r = 20;
        int d = r * 2;
        int s = d - 15;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,s));
        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter - r + 2,d - 2));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,s));
        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter + r - 2,d - 2));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel18(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        int r = 20;
        int d = r * 2;
        int s = d - 15;
        int m = 5;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,r - m));
        obstacles.addCoordinates(figures.right(xCenter + m,yCenter - r,r - m));

        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter - r,r - m));
        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter + m,r - m));

        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,r - m));
        obstacles.addCoordinates(figures.left(xCenter - m ,yCenter + r,r - m));

        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter + r,r - m));
        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter - m,r - m));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel19(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        //bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        int r = 20;
        int d = r * 2;
        int s = d - 15;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,s));
        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter - r + 2,d - 2));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,s));
        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter + r - 2,d - 2));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    private void startLevel20(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(1400);

        int side = 5;

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter - side,yCenter - side - 1,bubblesValue,2);
        bubbles.start(xCenter + side + 1,yCenter - side,bubblesValue,3);
        bubbles.start(xCenter + side,yCenter + side + 1,bubblesValue,4);
        bubbles.start(xCenter - side - 1,yCenter + side,bubblesValue,5);

        obstacles.addCoordinates(figures.up(55,72,54));
        obstacles.addCoordinates(figures.up(54,60,30));
        obstacles.addCoordinates(figures.up(56,60,30));
        obstacles.addCoordinates(figures.left(85,45,60));
        obstacles.addCoordinates(figures.left(70,44,30));
        obstacles.addCoordinates(figures.left(70,46,30));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

    // lis
    private void startLevel21(Bubbles bubbles, Snake snake,Obstacles obstacles,CalculationGameState calculationGameState){
        calculationGameState.setFinalTime(4000);

        snake.start(+15 + 0,+80,"right",snakeValue);
        bubbles.start(xCenter,yCenter,bubblesValue,2);
        bubbles.start(xCenter - 12,yCenter - 12,bubblesValue,3);

        int r = 27;
        int d = r * 2;
        int s = d - 10;
        obstacles.addCoordinates(figures.right(xCenter - r ,yCenter - r,d));
        obstacles.addCoordinates(figures.down(xCenter + r ,yCenter - r,d));
        obstacles.addCoordinates(figures.left(xCenter + r ,yCenter + r,s));
        obstacles.addCoordinates(figures.up(xCenter - r ,yCenter + r,d));

        obstacles.addCoordinates(figures.emptyRectangle(width,height,0));
    }

}
