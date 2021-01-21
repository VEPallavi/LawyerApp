package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ve.lawyer.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        clicks();
    }

    void clicks() {
        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();

        });
    }
}