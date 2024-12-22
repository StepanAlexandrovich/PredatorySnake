package com.bombacod.predatorysnake.levels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bombacod.predatorysnake.R;
import com.bombacod.predatorysnake.game.GameActivity;
import com.bombacod.predatorysnake.pf.GameState;
import com.bombacod.predatorysnake.pf.IntentKeyWords;

import java.io.Serializable;

public class LevelsActivity extends AppCompatActivity implements View.OnClickListener {
    public static int t = 0;
    private final int numberOfLevels = 21; // remake
    private final View[] levels = new View[numberOfLevels];

    private int topLevelIndex;
    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

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
        (levels[6] = findViewById(R.id.level_7)).setOnClickListener(this);
        (levels[7] = findViewById(R.id.level_8)).setOnClickListener(this);
        (levels[8] = findViewById(R.id.level_9)).setOnClickListener(this);
        (levels[9] = findViewById(R.id.level_10)).setOnClickListener(this);
        (levels[10] = findViewById(R.id.level_11)).setOnClickListener(this);
        (levels[11] = findViewById(R.id.level_12)).setOnClickListener(this);
        (levels[12] = findViewById(R.id.level_13)).setOnClickListener(this);
        (levels[13] = findViewById(R.id.level_14)).setOnClickListener(this);
        (levels[14] = findViewById(R.id.level_15)).setOnClickListener(this);
        (levels[15] = findViewById(R.id.level_16)).setOnClickListener(this);
        (levels[16] = findViewById(R.id.level_17)).setOnClickListener(this);
        (levels[17] = findViewById(R.id.level_18)).setOnClickListener(this);
        (levels[18] = findViewById(R.id.level_19)).setOnClickListener(this);
        (levels[19] = findViewById(R.id.level_20)).setOnClickListener(this);
        (levels[20] = findViewById(R.id.level_21)).setOnClickListener(this);

        for (int i = 0; i < numberOfLevels; i++) {
            ImageView imageView = levels[i].findViewById(R.id.imageLevel);

            switch (i + 1){
                case 1:imageView.setImageResource(R.drawable.level_1); break;
                case 2:imageView.setImageResource(R.drawable.level_2); break;
                case 3:imageView.setImageResource(R.drawable.level_3); break;
                case 4:imageView.setImageResource(R.drawable.level_4); break;
                case 5:imageView.setImageResource(R.drawable.level_5); break;
                case 6:imageView.setImageResource(R.drawable.level_6); break;
                case 7:imageView.setImageResource(R.drawable.level_7); break;
                case 8:imageView.setImageResource(R.drawable.level_8); break;
                case 9:imageView.setImageResource(R.drawable.level_9); break;
                case 10:imageView.setImageResource(R.drawable.level_10); break;
                case 11:imageView.setImageResource(R.drawable.level_11); break;
                case 12:imageView.setImageResource(R.drawable.level_12); break;
                case 13:imageView.setImageResource(R.drawable.level_13); break;
                case 14:imageView.setImageResource(R.drawable.level_14); break;
                case 15:imageView.setImageResource(R.drawable.level_15); break;
                case 16:imageView.setImageResource(R.drawable.level_16); break;
                case 17:imageView.setImageResource(R.drawable.level_17); break;
                case 18:imageView.setImageResource(R.drawable.level_18); break;
                case 19:imageView.setImageResource(R.drawable.level_19); break;
                case 20:imageView.setImageResource(R.drawable.level_20); break;
                case 21:imageView.setImageResource(R.drawable.level_21); break;
            }

            ImageView watch = levels[i].findViewById(R.id.imageClock); // rename imageClock
            if(i >= 5 && i <= 9){
                watch.setImageResource(R.drawable.clock);
            }else
            if(i >= 10 && i <= 14){
                watch.setImageResource(R.drawable.star_0);
            }else
            if(i >= 15 && i <= 19){
                watch.setImageResource(R.drawable.star_1);
            }else
            if(i >= 20){
                watch.setImageResource(R.drawable.fox);
            }

        }


        /////////////////
        Serializable levelDto = getIntent().getSerializableExtra(IntentKeyWords.LEVEL_DTO);
        topLevelIndex = dataBase.getTopLevelIndex();

        if(levelDto != null){
            LevelDto level = (LevelDto) levelDto;
            if(level.getIndex() == topLevelIndex && level.getGameState() == GameState.WINNING){
                if(topLevelIndex <= numberOfLevels){
                    topLevelIndex++;
                }
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
                int index = topLevelIndex - 1;
                if(index > numberOfLevels - 1){
                    index = numberOfLevels - 1;
                }
                View level = levels[index];
                int i = scrollView.getWidth()/2 - level.getWidth()/2;

                int x = (int)level.getX();

                scrollView.scrollTo(x - i, 0);
            }
        });


    }

}