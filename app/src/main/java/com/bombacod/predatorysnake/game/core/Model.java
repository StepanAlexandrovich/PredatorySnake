package com.bombacod.predatorysnake.game.core;

import com.bombacod.predatorysnake.pf.Direction;
import com.bombacod.predatorysnake.timing.SpeedMeasurement;
import com.bombacod.predatorysnake.game.core.objects.bubbles.Bubbles;
import com.bombacod.predatorysnake.game.core.layers.Layers;
import com.bombacod.predatorysnake.game.core.layers.LayersOptimization;
import com.bombacod.predatorysnake.game.core.matrix.Matrix;
import com.bombacod.predatorysnake.game.core.objects.obstacles.Obstacles;
import com.bombacod.predatorysnake.game.core.objects.snake.Snake;
import com.bombacod.predatorysnake.pf.GameState;

import java.util.ArrayList;

public class Model {
    // loop control
    private volatile int gameState;
    // timing
    private volatile int step;
    // habitat
    private Layers layers;
    // objects
    private Snake snake;
    private Snake snakeTest;
    private Bubbles bubbles;
    private Obstacles obstacles;

    private int levelIndex;

    private CalculationGameState calculationGameState;
    private StartGenerator startGenerator;

    private int direction  = Direction.RIGHT;

    // test
    public SpeedMeasurement speedMeasurement= new SpeedMeasurement(1000);

    public Model(int width, int height) {
//        layers = new LayersSimple(width,height);
        layers = new LayersOptimization(width,height);

        // live objects
        snake = new Snake(1,1,2, layers);
        snakeTest = new Snake(2,3,4, layers);
        bubbles = new Bubbles(layers);
        // static objects
        obstacles = new Obstacles(1,layers);

        calculationGameState = new CalculationGameState();
        startGenerator = new StartGenerator(width, height).setCenterCoordinate(width/2,height/2);

        gameState = GameState.WAITING;
        reset();
    }

    public Model setLevelIndex(int levelIndex) {
        this.levelIndex = levelIndex;
        gameState = GameState.WAITING;
        return this;
    }
    public void setGameState(int gameState) {
        this.gameState = gameState;
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
    public int getLevelIndex() {return levelIndex; }

    // objects
    public Bubbles getBubbles() { return bubbles; }
    public Snake getSnake() { return snake; }
    public Snake getSnakeTest() { return snakeTest; }
    public Obstacles getObstacles() { return obstacles; }

    // game control
    public void directly(){
        // do it
    }

    public void right() {
        snake.right();
        direction = Direction.RIGHT;
    }
    public void left()  {
        snake.left();
        direction = Direction.LEFT;
    }

    public void control(){
        if(direction == Direction.LEFT){
            direction = Direction.RIGHT;
            snake.right();
        }else{
            direction = Direction.LEFT;
            snake.left();
        }
    }
    public void restart(){ gameState = GameState.RESTART; }


    // not necessarily
    public String lastEvent() {
        return calculationGameState.getLastEvent();
    }

    ///////////////////////////////////
    private void symmetryTest(){
        if(gameState == GameState.RESTART){
            layers.reset();

            int xCenter = getWidth()/2;
            int yCenter = getHeight()/2;
            snake.start(xCenter - 15,yCenter,"left",10000);
            snakeTest.start(xCenter + 15,yCenter,"right",10000);

            gameState = GameState.PROCESS;
        }else
        if(gameState == GameState.PROCESS){
            layers.process();
            snake.process();
            snakeTest.process();
        }
    }
    
    public int getGameState(){ return gameState; }
    public int getDefeatCommit() { return calculationGameState.getDefeatCommit(); }

    private void reset(){
        step = 0;
        calculationGameState.reset();

        layers.reset();
        snake.restoreTypeHead();
        // bubbles do it
        obstacles.reset();
    }

    private void game(){
        speedMeasurement.process();/////////
        ////////////////////////////////////

        if(gameState == GameState.RESTART){
            reset();
            gameState = GameState.PROCESS;
        }else
        if(gameState == GameState.PROCESS){
            if(step == 0){ startGenerator.start(levelIndex,bubbles,snake,obstacles,calculationGameState); }

            layers.process();

            snake.process();
            bubbles.deleteBubble(snake.getTypeHead());
            bubbles.process();
//            fence.process();
            obstacles.process();

            gameState = calculationGameState.state(bubbles,snake,step);
            step++;
        }

    }

    public void process(){
//        symmetryTest();
        game();
    }
}
