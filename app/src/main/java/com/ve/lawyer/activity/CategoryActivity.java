package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ve.lawyer.R;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setClick();
    }


    void setClick() {
        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();

        });

        findViewById(R.id.rl_category).setOnClickListener((v) -> {

            startActivity(new Intent(CategoryActivity.this, MyPostActivity.class));
        });


    }
}