package com.bombacod.predatorysnake.startinit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bombacod.predatorysnake.R;
import com.bombacod.predatorysnake.help.HelpActivity;
import com.bombacod.predatorysnake.pf.Images;
import com.bombacod.predatorysnake.pf.StartupDownloads;

public class SplashActivity extends AppCompatActivity {
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        runnable = new Runnable() {
            @Override
            public void run() {
                StartupDownloads.start(); // remake
                Images.start(SplashActivity.this); // remake

                Intent intent = new Intent(SplashActivity.this, HelpActivity.class);
                startActivity(intent);
                finish();
            }
        };

        new Thread(runnable).start();
    }

}