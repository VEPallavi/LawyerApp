package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ve.lawyer.R;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        setClicks();

    }


    void setClicks() {

        findViewById(R.id.signin).setOnClickListener((v) -> {
            startActivity(new Intent(OptionsActivity.this, LoginActivity.class));
            finish();

        });
        findViewById(R.id.signup).setOnClickListener((v) -> {
            startActivity(new Intent(OptionsActivity.this, SignupActivity.class));
            finish();
        });

        findViewById(R.id.legal_que).setOnClickListener((v) -> {
            startActivity(new Intent(OptionsActivity.this, DashboardActivity.class));
            finish();
        });

    }

}