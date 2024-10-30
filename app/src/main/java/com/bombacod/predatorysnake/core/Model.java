package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.SpeedMeasurement;
import com.bombacod.predatorysnake.core.bubbles.Bubbles;
import com.bombacod.predatorysnake.core.matrices.Matrices;
import com.bombacod.predatorysnake.core.snake.Snake;

public class Model {
    private Matrices matrices;
    private Snake snake;
    private Snake snakeTest;
    private Bubbles bubbles;

    private int step = 0;
    public SpeedMeasurement speedMeasurement= new SpeedMeasurement(1000);

    public Model(int width, int height) {
        matrices = new Matrices(width,height);
        snake = new Snake(matrices,1,2);
        snakeTest = new Snake(matrices,3,4);
        bubbles = new Bubbles(matrices.getMatrixIdentity0());
    }

    // get
    public Matrices getMatrices() { return matrices; }
    public int getStep() { return step; }

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
        speedMeasurement.process();
        step++;

        if(step==1){
            matrices.getMatrixIdentity0().fillMatrix(0);
            matrices.getMatrixIdentity1().fillMatrix(0);
            matrices.getMatrixTrack().fillMatrix(200);

            snake.start(+15,+80,"directly");
            //snakeTest.start(+10 + 15,0,"directly");

            bubbles.startMatrix(40,40,2,3,10);
            //bubbles.start(50,50,5000,2);
        }

        snake.process();
        //snakeTest.process();

        bubbles.deleteBubble(snake.getTypeHead());
        bubbles.process();

        matrices.process();
    }
}
