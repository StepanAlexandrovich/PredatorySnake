package com.bombacod.predatorysnake.core;

import com.bombacod.predatorysnake.core.objects.bubbles.Bubbles;
import com.bombacod.predatorysnake.core.objects.snake.Snake;
import com.bombacod.predatorysnake.pf.GameState;

public class CalculationGameState {
    private int finalTime;
    private String lastEvent = "";

    public CalculationGameState(int finalTime) {
        this.finalTime = finalTime;
    }

    public String getLastEvent() {
        return lastEvent;
    }

    //////////////////////////
    public int state(Bubbles bubbles,Snake snake,int step){
        int state = 0;

        if(!snake.isLife()){
            state = GameState.DEFEAT;
            lastEvent = "snake is dead";
        }else
        if(step > finalTime){
            state = GameState.DEFEAT;
            lastEvent = "time is ended";
        }else
        if(bubbles.getNumber() != 0){
            state = GameState.PROCESS;
            lastEvent = "time is left " + (finalTime - step);
        }else
        if(bubbles.getNumber() == 0){
            state = GameState.WINNING;
            lastEvent = "time is left " + (finalTime - step);
        }

        return state;
    }

}
