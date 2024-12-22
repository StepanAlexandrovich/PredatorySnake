package com.bombacod.predatorysnake.levels;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class DataBase {
    private String name;
    private SharedPreferences preferences;
    private final String safeKeyMaxLevelIndex = "maxLevelIndex";

    public DataBase(Context context) {
        name = "DataBase";
        preferences = context.getSharedPreferences(name, MODE_PRIVATE);
    }

    public int getTopLevelIndex(){
        return preferences.getInt(safeKeyMaxLevelIndex, 1);
    }

    public void setTopLevelIndex(int levelMaxIndex){
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt(safeKeyMaxLevelIndex, levelMaxIndex);
        edit.apply();
    }

}
