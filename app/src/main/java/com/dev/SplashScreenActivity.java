package com.dev;

import android.os.Bundle;
import android.os.Handler;

import com.appbasehelpers.AppBaseActivityHelper;

public class SplashScreenActivity extends AppBaseActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setSplashScreenBarColor();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToSelectYourLanguageActivity(null);
            }
        },3000);
    }
}
