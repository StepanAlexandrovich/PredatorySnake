package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.core.matrices.Matrices;
import com.bombacod.predatorysnake.core.snake.Snake;

public class Model {
    private Matrices matrices;
    private Snake snake;
    private Snake snakeTest;
    //private Bubbles bubbles = new Bubbles(width,height);

    private int step = 0;

    public Model(int width, int height) {
        matrices = new Matrices(width,height);
        snake = new Snake(matrices,1,1,2);
        snakeTest = new Snake(matrices,3,3,4);
    }

    // get
    public Matrices getMatrices() { return matrices; }

    // encapsulation
    public int getLength(){ return matrices.getLength(); }
    public int getWidth() {
        return matrices.getWidth();
    }
    public int getHeight() {
        return matrices.getHeight();
    }
    public int getX(int index){ return matrices.getX(index); }
    public int getY(int index){ return matrices.getY(index); }

    // objects
    public Snake getSnake() { return snake; }
    public Snake getSnakeTest() { return snakeTest; }

    // control
    public void right(){
        snake.right();
    }
    public void left(){
        snake.left();
    }

    ///////////////////////////////////
    public void process(){
        step++;

        if(step==1){
            matrices.getMatrixIdentity0().fillMatrix(0);
            matrices.getMatrixIdentity1().fillMatrix(0);
            matrices.getMatrixTrack().fillMatrix(200);

            snake.start(-10,0,"left");
            snakeTest.start(+10,0,"right");
            //bubbles.start();
        }

        snake.process();
        snakeTest.process();
        //bubbles.process();

        matrices.process();
    }
}
