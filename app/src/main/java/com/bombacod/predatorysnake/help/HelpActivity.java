package com.bombacod.predatorysnake.help;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bombacod.predatorysnake.R;
import com.bombacod.predatorysnake.levels.LevelsActivity;
import com.bombacod.predatorysnake.startinit.SplashActivity;

public class HelpActivity extends AppCompatActivity {
    private Toast toast;
    private View progressBarCircle;
    private View buttonHelp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_help);

        progressBarCircle = findViewById(R.id.progressBarCircle);
        buttonHelp = findViewById(R.id.button_help);
        progressBarCircle.setVisibility(View.INVISIBLE);

        // web
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        WebViewClient webViewClient = new WebViewClient() {
            @SuppressWarnings("deprecation") @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @TargetApi(Build.VERSION_CODES.N) @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        };
        webView.setWebViewClient(webViewClient);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                if(newProgress == 100){
                    progressBar.setVisibility(View.INVISIBLE);
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                }
                super.onProgressChanged(view,newProgress);
            }
        });

        // buttons
        View next = findViewById(R.id.button_next);
        next.setOnClickListener(view -> {
            toast = Toast.makeText(this, "wait for minute", Toast.LENGTH_LONG);
            toast.show();

            progressBarCircle.setVisibility(View.VISIBLE);
            buttonHelp.setVisibility(View.INVISIBLE);

            next.setScaleX(next.getScaleX()*0.9F);
            next.setScaleY(next.getScaleY()*0.9F);

            Intent intent = new Intent(HelpActivity.this, LevelsActivity.class);
            startActivity(intent);
            finish();
        });

//        View help = findViewById(R.id.button_help);
//        help.setOnClickListener(view -> {
//            help.setVisibility(View.INVISIBLE);
//            webView.loadUrl("https://youtu.be/F9e0A7S9T2o");
//        });

        buttonHelp.setOnClickListener(view -> {
            buttonHelp.setVisibility(View.INVISIBLE);
            webView.loadUrl("https://youtu.be/F9e0A7S9T2o");
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toast.cancel();
    }
}