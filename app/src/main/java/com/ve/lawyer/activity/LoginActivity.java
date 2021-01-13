package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ve.lawyer.R;
import com.ve.lawyer.utils.Utils;

public class LoginActivity extends AppCompatActivity {

    private EditText et_email, et_pass;
    private LinearLayout ll_email;
    private RelativeLayout ll_pass;
    private boolean isPasswordShow = false;

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
            startActivity(new Intent(LoginActivity.this, ForgotPsswordActivity.class));
        });

        findViewById(R.id.sign_in).setOnClickListener((v) -> {

            if (!TextUtils.isEmpty(et_email.getText().toString().trim())) {
                if (Utils.isValidEmailId(et_email.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(et_pass.getText().toString().trim())) {

                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                        finishAffinity();
                    } else {
                        Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Please enter valid email id", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter email id", Toast.LENGTH_SHORT).show();
            }

        });


        eye.setOnClickListener((v) -> {
            if (isPasswordShow) {
                et_pass.setInputType(InputType.TYPE_CLASS_TEXT);
                et_pass.setTransformationMethod(null);
                eye.setBackgroundResource(R.drawable.eye_on_icon);
            } else {
                eye.setBackgroundResource(R.drawable.eye_off_icon);
                et_pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                et_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            isPasswordShow = !isPasswordShow;
        });


    }
}