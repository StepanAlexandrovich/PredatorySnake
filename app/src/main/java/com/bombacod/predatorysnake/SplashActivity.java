package com.bombacod.predatorysnake;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bombacod.predatorysnake.core.Model;
import com.bombacod.predatorysnake.pf.Dimensions;
import com.bombacod.predatorysnake.pf.StartupDownloads;
import com.bombacod.predatorysnake.visualization.Render;

public class SplashActivity extends AppCompatActivity {
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        runnable = new Runnable() {
            @Override
            public void run() {
                StartupDownloads.model = new Model(Dimensions.GAME_WIDTH,Dimensions.GAME_HEIGHT);
                StartupDownloads.render = new Render();
                System.out.println();
                Images.restart = BitmapFactory.decodeResource(getResources(),R.drawable.restart);  // bad decision
                Images.defeat = BitmapFactory.decodeResource(getResources(),R.drawable.defeat);  // bad decision
                Images.win = BitmapFactory.decodeResource(getResources(),R.drawable.win);  // bad decision

                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        new Thread(runnable).start();
    }

}