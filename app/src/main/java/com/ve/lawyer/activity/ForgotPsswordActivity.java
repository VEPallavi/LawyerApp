package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ve.lawyer.R;

public class ForgotPsswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pssword);
        clicks();
    }


    void clicks() {
        findViewById(R.id.reset).setOnClickListener((v) -> {
            finish();
        });

        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();
        });
    }


}