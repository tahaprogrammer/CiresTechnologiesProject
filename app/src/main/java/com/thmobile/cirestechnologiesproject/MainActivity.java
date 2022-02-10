package com.thmobile.cirestechnologiesproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check if EditTexts is Empties
                if (editTextUsername.getText().toString().trim().length() > 0 && editTextPassword.getText().toString().trim().length() > 0) {

                    String username = editTextUsername.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();

                    //check blocked users
                    if (username.equals(Utils.BlockedUser.getUsername()) && password.equals(Utils.BlockedUser.getPassword())) {
                        showDialogMessage("Warning!", "This Email is Blocked");
                    } else if (username.equals(Utils.AccessUser.getUsername()) && password.equals(Utils.AccessUser.getPassword())) {
                        //Access Successfully
                        launchActivity();
                    } else {
                        showDialogMessage("Error!","This data is not Available into our databases!");
                    }

                }
            }
        });
    }

    private void launchActivity() {
        startActivity(new Intent(this, NewsActivity.class));
        finish();
    }

    private void init() {
        editTextUsername = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    private void showDialogMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        editTextUsername.getText().clear();
                        editTextPassword.getText().clear();
                    }
                });
        Dialog dialog = builder.create();
        dialog.show();
    }
}