package com.bombacod.predatorysnake.levels;

import java.io.Serializable;

public class LevelDto implements Serializable {
    private int index;
    private int gameState;

    public LevelDto(int index, int gameState) {
        this.index = index;
        this.gameState = gameState;
    }

    public int getIndex() {
        return index;
    }

    public int getGameState() {
        return gameState;
    }
}
