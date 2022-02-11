package com.thmobile.cirestechnologiesproject.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.thmobile.cirestechnologiesproject.R;
import com.thmobile.cirestechnologiesproject.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //startActivity(new Intent(this , NewsActivity.class));

        //2 second of loading
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                launchActivity();
            }
        }, 2000);
    }

    private void launchActivity() {
        //check if the user is this is the first time opened the app
        Intent intent;
        if (checkFirstUsage()) {
            intent = new Intent(SplashActivity.this, FirstUsageActivity.class);
        } else {
            intent = new Intent(SplashActivity.this, MainActivity.class);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }

    private boolean checkFirstUsage() {
        //check first time use
        SharedPreferences sharedPreferences = getSharedPreferences(Utils.FIRST_USAGE_KET, MODE_PRIVATE);
        return !sharedPreferences.getBoolean(Utils.FIRST_USAGE_KET, false);
    }

    @Override
    public void onBackPressed() {

    }
}