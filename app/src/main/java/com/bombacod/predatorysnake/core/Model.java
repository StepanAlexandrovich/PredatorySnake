package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.SpeedMeasurement;
import com.bombacod.predatorysnake.core.bubbles.Bubbles;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.obstacle.Fence;
import com.bombacod.predatorysnake.core.obstacle.Square;
import com.bombacod.predatorysnake.core.snake.Snake;

public class Model {
    private Layers layers;

    private Snake snake;
    private Snake snakeTest;

    private Bubbles bubbles;

    //private Square square;
    private Fence fence;

    private GameState gameState;



    // test
    public SpeedMeasurement speedMeasurement= new SpeedMeasurement(1000);

    public Model(int width, int height) {
        layers = new Layers(width,height);

        snake = new Snake(1,1,2, layers);
        snakeTest = new Snake(2,3,4, layers);
        bubbles = new Bubbles(layers);

        //square = new Square(1,0,0,10,10,layers);
        fence = new Fence(1,layers);

        gameState = new GameState(1500,snake,bubbles);
    }

    // layers encapsulation
    public Layers getLayers() { return layers; }
    public Matrix getMatrix0() { return layers.getPlane0().getMatrix();}
    public Matrix getMatrix1() { return layers.getPlane1().getMatrix();}
    public Matrix getMatrix2() { return layers.getPlane2().getMatrix();}
    public Matrix getMatrix3() { return layers.getPlane3().getMatrix();}

    public int getLength(){ return layers.getLength(); }
    public int getWidth() {
        return layers.getWidth();
    }
    public int getHeight() {
        return layers.getHeight();
    }
    public int getX(int index){ return layers.getX(index); }
    public int getY(int index){ return layers.getY(index); }

    // gameState encapsulation
    public int getStep() { return gameState.getStep(); }
    public String gameStateText() { return gameState.text(); }

    // objects
    public Bubbles getBubbles() { return bubbles; }
    public Snake getSnake() { return snake; }
    public Snake getSnakeTest() { return snakeTest; }
    public Fence getFence() { return fence; }

    // control
    public void right(){
        snake.right();
    }
    public void left(){
        snake.left();
    }


    ///////////////////////////////////
    private void reset(){
        layers.getPlane0().getMatrix().fillMatrix(0);
        layers.getPlane1().getMatrix().fillMatrix(0);
        layers.getPlane2().getMatrix().fillMatrix(200);
    }

    private void symmetryTest(){
        speedMeasurement.process();/////////
        ////////////////////////////////////

        if(gameState.getStep() == 0){
            reset();

            int xCenter = getWidth()/2;
            snake.start(xCenter - 15,0,"right");
            snakeTest.start(xCenter + 15,0,"left");
        }

        layers.process();

        snake.process();
        snakeTest.process();

        gameState.process();
    }

    private void game(){
        speedMeasurement.process();/////////
        ////////////////////////////////////

        if(gameState.getStep() == 0){
            reset();

            snake.start(+15,+80,"right");
            bubbles.startMatrix(40,40,2,2,10);
            //bubbles.start(50,50,5000,2);
        }

        layers.process();

        snake.process();
        bubbles.deleteBubble(snake.getTypeHead());
        bubbles.process();
        fence.process();

        ////////////////////////////
        gameState.process();////////
    }

    public void process(){
        //symmetryTest();
        game();
    }
}
