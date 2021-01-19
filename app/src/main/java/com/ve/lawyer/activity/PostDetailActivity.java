package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ve.lawyer.R;

public class PostDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        clicks();
    }

    void clicks() {

        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();


        });
       
    }
}