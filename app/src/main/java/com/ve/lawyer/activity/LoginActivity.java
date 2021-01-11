package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ve.lawyer.R;

public class LoginActivity extends AppCompatActivity {

    private EditText et_email, et_pass;
    private LinearLayout ll_email;
    private RelativeLayout ll_pass;

    private ImageView eye, pass_icon, email_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        ll_email = findViewById(R.id.ll_email);
        email_icon = findViewById(R.id.email_icon);


        eye = findViewById(R.id.eye);
        pass_icon = findViewById(R.id.pass_icon);
        ll_pass = findViewById(R.id.ll_pass);

        clicks();
    }

    void clicks() {


        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();
        });


        et_email.setOnFocusChangeListener((v, b) -> {

            if (b) {
                ll_email.setBackgroundResource(R.drawable.edit_text_selected);
                ll_pass.setBackgroundResource(R.drawable.edit_text_un_selected);

                email_icon.setBackgroundResource(R.drawable.email_on_icon);
                pass_icon.setBackgroundResource(R.drawable.lock_off_icon);
                eye.setBackgroundResource(R.drawable.eye_off_icon);
            }


        });

        et_pass.setOnFocusChangeListener((v, b) -> {
            ll_pass.setBackgroundResource(R.drawable.edit_text_selected);
            ll_email.setBackgroundResource(R.drawable.edit_text_un_selected);
            email_icon.setBackgroundResource(R.drawable.email_off_icon);
            pass_icon.setBackgroundResource(R.drawable.lock_on_icon);
            eye.setBackgroundResource(R.drawable.eye_on_icon);

        });

        findViewById(R.id.txt_forgotpass).setOnClickListener((v) -> {


        });

        findViewById(R.id.sign_in).setOnClickListener((v) -> {


        });


    }
}