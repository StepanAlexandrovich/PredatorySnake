package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.core.bubbles.Bubbles;
import com.bombacod.predatorysnake.core.snake.Snake;

import java.util.Objects;

public class GameState {
    private static final String PROCESS = "PROCESS";
    private static final  String WINNING = "WINNING";
    private static final  String DEFEAT = "DEFEAT";

    private int finalTime;
    private Snake snake;
    private Bubbles bubbles;

    private int step;
    private String gameState,commit;

    public GameState(int finalTime, Snake snake, Bubbles bubbles) {
        this.finalTime = finalTime;
        this.snake = snake;
        this.bubbles = bubbles;

        gameState = PROCESS;
    }

    public boolean isProcess(){ return Objects.equals(gameState, PROCESS); }
    public int getStep() { return step; }
    public String text(){ return gameState + commit; }

    //////////////////////////
    public void process(){

        if(Objects.equals(gameState, PROCESS)){
            step++;

            if(!snake.isLife()){
                gameState = DEFEAT;
                commit = "(snake is dead)";
            }else
            if(step > finalTime){
                gameState = DEFEAT;
                commit = "(time is ended)";
            }else
            if(bubbles.getNumber() != 0){
                gameState = PROCESS;
                commit = "(current time " + step + ")";
            }else
            if(bubbles.getNumber() == 0){
                gameState = WINNING;
                commit = "(current time " + step + ")";
            }

        }

    }

}
