package com.thmobile.cirestechnologiesproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                launchActivity();
            }
        }, 3000);
    }

    private void launchActivity() {
        Intent intent;
        if (checkFirstUsage()) {
            intent = new Intent(SplashActivity.this, FirstUsageActivity.class);
        } else {
            intent = new Intent(SplashActivity.this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

    private boolean checkFirstUsage() {
        SharedPreferences sharedPreferences = getSharedPreferences(Utils.FIRST_USAGE_KET, MODE_PRIVATE);
        return !sharedPreferences.getBoolean(Utils.FIRST_USAGE_KET, false);
    }

    @Override
    public void onBackPressed() {

    }
}