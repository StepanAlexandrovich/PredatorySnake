package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.SpeedMeasurement;
import com.bombacod.predatorysnake.core.objects.bubbles.Bubbles;
import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.layers.LayersOptimization;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.objects.obstacle.Fence;
import com.bombacod.predatorysnake.core.objects.snake.Snake;
import com.bombacod.predatorysnake.pf.GameState;

public class Model {
    // loop control
    private int gameState;
    private boolean restart;

    // timing
    private int step;
    // habitat
    private Layers layers;
    // objects
    private Snake snake;
    private Snake snakeTest;
    private Bubbles bubbles;
    private Fence fence;

    private CalculationGameState calculationGameState;

    // test
    public SpeedMeasurement speedMeasurement= new SpeedMeasurement(1000);

    public Model(int width, int height) {
//        layers = new LayersSimple(width,height);
        layers = new LayersOptimization(width,height);

        snake = new Snake(1,1,2, layers);
        snakeTest = new Snake(2,3,4, layers);
        bubbles = new Bubbles(layers);
        fence = new Fence(1, layers);

        calculationGameState = new CalculationGameState(4000);

        //restart();
        gameState = GameState.INSTRUCTION;
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

    public int getStep() { return step; }
    public int gameState(){ return gameState; }

    // objects
    public Bubbles getBubbles() { return bubbles; }
    public Snake getSnake() { return snake; }
    public Snake getSnakeTest() { return snakeTest; }
    public Fence getFence() { return fence; }

    // game control
    public void directly(){
        // do it
    }

    public void right() { snake.right(); }
    public void left()  { snake.left(); }
    public void restart(){ restart = true; }

    // not necessarily
    public String lastEvent() {
        return calculationGameState.getLastEvent();
    }

    ///////////////////////////////////
    private void symmetryTest(){
        if(restart){
            layers.reset();

            int xCenter = getWidth()/2;
            int yCenter = getHeight()/2;
            snake.start(xCenter - 15,yCenter,"left",10000);
            snakeTest.start(xCenter + 15,yCenter,"right",10000);

            restart = false;
        }else{
            layers.process();
            snake.process();
            snakeTest.process();
        }
    }

    private void reset(){
        step = 0;
        layers.reset();
        snake.restoreTypeHead();
        // bubbles do it
    }

    private void game(){
        speedMeasurement.process();/////////
        ////////////////////////////////////

        if(restart){
            reset();
            gameState = GameState.PROCESS;

            restart = false;
        }else
        if(gameState == GameState.PROCESS){
            if(step == 0){
                snake.start(+15,+80,"right",10000);
                bubbles.startFour(getWidth()/2,getHeight()/2,2,5,4000);
//                bubbles.start(50,50,5000,2);
            }

            layers.process();

            snake.process();
            bubbles.deleteBubble(snake.getTypeHead());
            bubbles.process();
            fence.process();

            gameState = calculationGameState.state(bubbles,snake,step);
            step++;
        }

    }

    public void process(){
//        symmetryTest();
        game();
    }
}
