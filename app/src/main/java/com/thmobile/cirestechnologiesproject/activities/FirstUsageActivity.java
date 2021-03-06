package com.thmobile.cirestechnologiesproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thmobile.cirestechnologiesproject.R;
import com.thmobile.cirestechnologiesproject.utils.Utils;

public class FirstUsageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_usage);

        //Start Button
        findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
    }

    private void launchActivity() {
        startActivity(new Intent(FirstUsageActivity.this, MainActivity.class));
        //Save First Usage into SharedPreferences
        getSharedPreferences(Utils.FIRST_USAGE_KET, MODE_PRIVATE).edit().putBoolean(Utils.FIRST_USAGE_KET, true).apply();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
}