package com.bombacod.predatorysnake;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bombacod.predatorysnake.pf.GameState;
import com.bombacod.predatorysnake.pf.IntentKeyWords;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button level1,level2,level3,level4;

    private int topLevelIndex;
    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    private void initialization(){
        (level1 = findViewById(R.id.level1)).setOnClickListener(this);
        (level2 = findViewById(R.id.level2)).setOnClickListener(this);
        (level3 = findViewById(R.id.level3)).setOnClickListener(this);
        (level4 = findViewById(R.id.level4)).setOnClickListener(this);

        dataBase = new DataBase(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.level1 && topLevelIndex >= 1){
            newWindow(1);
        }else
        if(view.getId() == R.id.level2 && topLevelIndex >= 2){
            newWindow(2);
        }else
        if(view.getId() == R.id.level3 && topLevelIndex >= 3){
            newWindow(3);
        }else
        if(view.getId() == R.id.level4 && topLevelIndex >= 4){
            newWindow(4);
        }
    }

    private void newWindow(int levelIndex){
        try {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra(IntentKeyWords.LEVEL_INDEX,levelIndex);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Serializable levelDto = getIntent().getSerializableExtra(IntentKeyWords.LEVEL_DTO);
        topLevelIndex = dataBase.getTopLevelIndex();

        if(levelDto != null){
            LevelDto level = (LevelDto) levelDto;
            if(level.getIndex() == topLevelIndex && level.getGameState() == GameState.WINNING){
                topLevelIndex++;
                dataBase.setTopLevelIndex(topLevelIndex);
            }
        }

        buttonsVisualization(topLevelIndex);
    }

    private void buttonsVisualization(int topLevelIndex){
        if(topLevelIndex == 1){
            level1.setBackgroundColor(Color.RED);
        }
        if(topLevelIndex == 2){
            level2.setBackgroundColor(Color.RED);
        }
        if(topLevelIndex == 3){
            level3.setBackgroundColor(Color.RED);
        }
        if(topLevelIndex == 4){
            level4.setBackgroundColor(Color.RED);
        }

        if(topLevelIndex > 1){
            level1.setBackgroundColor(Color.GREEN);
        }
        if(topLevelIndex > 2){
            level2.setBackgroundColor(Color.GREEN);
        }
        if(topLevelIndex > 3){
            level3.setBackgroundColor(Color.GREEN);
        }
        if(topLevelIndex > 4){
            level4.setBackgroundColor(Color.GREEN);
        }
    }

}