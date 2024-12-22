package com.bombacod.predatorysnake.game.core;

import com.bombacod.predatorysnake.game.core.objects.bubbles.Bubbles;
import com.bombacod.predatorysnake.game.core.objects.snake.Snake;
import com.bombacod.predatorysnake.pf.GameState;
import com.bombacod.predatorysnake.pf.DefeatCommit;

public class CalculationGameState {
    private int finalTime;
    private int restTimeDefeat,restTimeWin;
    private String lastEvent;
    private int defeatCommit;

    public String getLastEvent() {
        return lastEvent;
    }
    public int getDefeatCommit() { return defeatCommit; }

    public void setFinalTime(int finalTime) {
        this.finalTime = finalTime;
    }
    public void reset(){
        lastEvent = "";
        defeatCommit = DefeatCommit.NOT;
        restTimeDefeat = 100;
        restTimeWin = 100;
    }

    //////////////////////////
    public int state(Bubbles bubbles, Snake snake, int step){
        int state = 0;

        if(step > finalTime){
            state = GameState.DEFEAT;
            lastEvent = "time is ended";
            defeatCommit = DefeatCommit.TIME_IS_UP;
        }else
        if(!snake.isLife() && restTimeDefeat > 0){
            state = GameState.PROCESS;
            restTimeDefeat--;
            lastEvent = "time is left " + (finalTime - step);
        }else
        if(restTimeDefeat == 0){
            state = GameState.DEFEAT;
            lastEvent = "snake is dead";
            defeatCommit = DefeatCommit.DEATH;
        }else
        if(bubbles.getNumber() != 0){
            state = GameState.PROCESS;
            lastEvent = "time is left " + (finalTime - step);
        }else
        if(bubbles.getNumber() == 0 && restTimeWin > 0){
            state = GameState.PROCESS;
            restTimeWin--;
            lastEvent = "time is left " + (finalTime - step);
        }else
        if(restTimeWin == 0){
            state = GameState.WINNING;
            lastEvent = "time is left " + (finalTime - step);
        }

        return state;
    }

}
