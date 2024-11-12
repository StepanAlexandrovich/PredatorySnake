package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.SpeedMeasurement;
import com.bombacod.predatorysnake.core.bubbles.Bubbles;
import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.layers.LayersOptimization;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.layers.LayersSimple;
import com.bombacod.predatorysnake.core.obstacle.Fence;
import com.bombacod.predatorysnake.core.snake.Snake;

public class Model {
    private Layers layers;

    private Snake snake;
    private Snake snakeTest;
    private Bubbles bubbles;
    private Fence fence;

    private GameState gameState;
    private boolean restart;

    // test
    public SpeedMeasurement speedMeasurement= new SpeedMeasurement(1000);

    public Model(int width, int height) {
        //layers = new LayersSimple(width,height);
        layers = new LayersOptimization(width,height);

        snake = new Snake(1,1,2, layers);
        snakeTest = new Snake(2,3,4, layers);
        bubbles = new Bubbles(layers);
        fence = new Fence(1, layers);

        gameState = new GameState(4000);

        restart();
    }

    // layers encapsulation
    public Layers getLayers() { return layers; }
    public Matrix getMatrix0() { return layers.getLayer0().getMatrix();}
    public Matrix getMatrix1() { return layers.getLayer1().getMatrix();}
    public Matrix getMatrix2() { return layers.getLayer2().getMatrix();}
    public Matrix getMatrix3() { return layers.getLayer3().getMatrix();}

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
    public void restart(){ restart = true; }

    ///////////////////////////////////
    private void symmetryTest(){
        if(restart){
            layers.reset();
            gameState.reset();

            int xCenter = getWidth()/2;
            snake.start(xCenter - 15,0,"right");
            snakeTest.start(xCenter + 15,0,"left");

            restart = false;
        }else{
            layers.process();
            snake.process();
            snakeTest.process();
        }
    }

    private void game(){
        speedMeasurement.process();/////////
        ////////////////////////////////////

        if(restart){
            layers.reset();
            gameState.reset();

            snake.restoreTypeHead();
            snake.start(+15,+80,"right");
            bubbles.startMatrix(40,40,2,2,10);
            //bubbles.start(50,50,5000,2);
            restart = false;
        }else
        if(gameState.isProcess()){
            layers.process();

            snake.process();

            bubbles.deleteBubble(snake.getTypeHead());
            bubbles.process();
            fence.process();

            gameState.process(bubbles,snake);
        }

    }

    public void process(){
        //symmetryTest();
        game();
    }
}
