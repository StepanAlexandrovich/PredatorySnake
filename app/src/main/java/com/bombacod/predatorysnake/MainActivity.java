package com.bombacod.predatorysnake;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.pf.Dimensions;
import com.bombacod.predatorysnake.pf.GameState;
import com.bombacod.predatorysnake.pf.IntentKeyWords;
import com.bombacod.predatorysnake.pf.StartupDownloads;
import com.bombacod.predatorysnake.visualization.Render;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final int numberOfLevels = 6; // remake
    private final View[] levels = new View[numberOfLevels];

    private int topLevelIndex;
    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    private void initialization(){
        dataBase = new DataBase(this);

        (levels[0] = findViewById(R.id.level_1)).setOnClickListener(this);
        (levels[1] = findViewById(R.id.level_2)).setOnClickListener(this);
        (levels[2] = findViewById(R.id.level_3)).setOnClickListener(this);
        (levels[3] = findViewById(R.id.level_4)).setOnClickListener(this);
        (levels[4] = findViewById(R.id.level_5)).setOnClickListener(this);
        (levels[5] = findViewById(R.id.level_6)).setOnClickListener(this);

//        View viewById = levels[0].findViewById(R.id.imageStateLevel);
//        ((ImageView)viewById).setVisibility(View.INVISIBLE);

        for (int i = 0; i < numberOfLevels; i++) {
            ImageView imageView = levels[i].findViewById(R.id.imageLevel);

            switch (i + 1){
                case 1:imageView.setImageResource(R.drawable.level_1); break;
                case 2:imageView.setImageResource(R.drawable.level_2); break;
                case 3:imageView.setImageResource(R.drawable.level_3); break;
                case 4:imageView.setImageResource(R.drawable.level_4); break;
                case 5:imageView.setImageResource(R.drawable.level_5); break;
                case 6:imageView.setImageResource(R.drawable.level_6); break;
            }
        }


        /////////////////
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
        scrolling(topLevelIndex);
    }

    @Override
    public void onClick(View view) {
        for (int i = 1; i <= numberOfLevels; i++) {
            if(view.getId() == levels[i - 1].getId() && topLevelIndex >= i){
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

    private void buttonsVisualization(int topLevelIndex){
        for (int i = 0; i < numberOfLevels; i++) {
            ImageView imageView = levels[i].findViewById(R.id.imageLevel);
            int level = i + 1;
            if(level > topLevelIndex){
                imageView.setAlpha(0.5F);
            }else
            if(level <= topLevelIndex){
                imageView.setAlpha(1.0F);
            }
        }

        for (int i = 0; i < numberOfLevels; i++) {
            ImageView imageView = levels[i].findViewById(R.id.imageStateLevel);
            int level = i + 1;
            if(level < topLevelIndex){
                imageView.setImageResource(R.drawable.completed);
            }else
            if(level == topLevelIndex){
                imageView.setImageResource(R.drawable.open);
            }else
            if(level > topLevelIndex){
                imageView.setImageResource(R.drawable.close);
                imageView.setAlpha(0.8F);
            }
        }
    }

    private void scrolling(int topLevelIndex){
        View scrollView = findViewById(R.id.scrollViewHorizontal);
        scrollView.post(new Runnable() {
            public void run() {
                int x = (int)levels[topLevelIndex - 1].getX();
                scrollView.scrollTo(x, 0);
            }
        });
    }

}