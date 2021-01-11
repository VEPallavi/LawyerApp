package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.ve.lawyer.R;

public class UserTypeActivity extends AppCompatActivity {

    private ConstraintLayout cl_lawyer, cl_client;
    ImageView client_chekbox, law_chekbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        cl_lawyer = findViewById(R.id.cl_lawyer);
        cl_client = findViewById(R.id.cl_client);
        client_chekbox = findViewById(R.id.client_chekbox);
        law_chekbox = findViewById(R.id.law_chekbox);

        clicks();
    }


    void clicks() {
        cl_client.setOnClickListener((v) -> {


            cl_client.setBackgroundResource(R.drawable.bg_user_select);
            cl_lawyer.setBackgroundResource(R.drawable.bg_user_unselect);

            client_chekbox.setBackgroundResource(R.drawable.check_icon);
            law_chekbox.setBackgroundResource(R.drawable.uncheck_icon);


        });
        cl_lawyer.setOnClickListener((v) -> {

            cl_lawyer.setBackgroundResource(R.drawable.bg_user_select);
            cl_client.setBackgroundResource(R.drawable.bg_user_unselect);

            law_chekbox.setBackgroundResource(R.drawable.check_icon);
            client_chekbox.setBackgroundResource(R.drawable.uncheck_icon);

        });

        findViewById(R.id.next).setOnClickListener((v) -> {

            startActivity(new Intent(UserTypeActivity.this, OptionsActivity.class));
            finish();

        });

        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();
        });


    }
}