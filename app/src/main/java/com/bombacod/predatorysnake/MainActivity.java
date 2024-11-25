package com.bombacod.predatorysnake;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bombacod.predatorysnake.pf.GameState;
import com.bombacod.predatorysnake.pf.IntentKeyWords;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final int numberOfLevels = 5;
    private final Button[] levels = new Button[numberOfLevels];

    private int topLevelIndex;
    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    private void initialization(){
        LinearLayout list = findViewById(R.id.list_levels);

        for (int i = 1; i <= numberOfLevels; i++) {
            Button button = new Button(this);
            button.setId(i);
            button.setText("level" + i);
            button.setOnClickListener(this);
            list.addView(button);

            levels[i - 1] = button;
        }

        dataBase = new DataBase(this);
        Images.instruction = BitmapFactory.decodeResource(getResources(),R.drawable.instruction);  // bad decision
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        for (int i = 1; i <= numberOfLevels; i++) {
            if(view.getId() == i && topLevelIndex >= i){
                newWindow(i);
            }
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

    @SuppressLint("ResourceType")
    private void buttonsVisualization(int topLevelIndex){
        for (Button level : levels) {
            if(level.getId() == topLevelIndex){
                level.setBackgroundColor(Color.RED);
            }
        }

        for (Button level : levels) {
            if(level.getId() < topLevelIndex){
                level.setBackgroundColor(Color.GREEN);
            }
        }

    }

}