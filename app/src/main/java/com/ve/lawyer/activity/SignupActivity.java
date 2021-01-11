package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ve.lawyer.R;

public class SignupActivity extends AppCompatActivity {

    private LinearLayout ll_terms;
    private ImageView img_checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ll_terms = findViewById(R.id.ll_terms);
        img_checkbox = findViewById(R.id.img_checkbox);
        clicks();
    }

    void clicks() {


        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();
        });




        findViewById(R.id.ll_terms).setOnClickListener((v) -> {
            img_checkbox.setBackgroundResource(R.drawable.check_box_icon);

        });

        findViewById(R.id.sign_up).setOnClickListener((v) -> {


        });


    }
}