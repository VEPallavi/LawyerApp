package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ve.lawyer.R;
import com.ve.lawyer.utils.Utils;

public class SignupActivity extends AppCompatActivity {

    private LinearLayout ll_terms;
    private ImageView img_checkbox, eye, cnf_eye;
    private EditText et_user, et_last_name, et_email, et_pass, cnf_et_pass;
    private boolean isTermSelect = false;
    private boolean isPasswordShow = false;
    private boolean isCnfPasswordShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ll_terms = findViewById(R.id.ll_terms);
        img_checkbox = findViewById(R.id.img_checkbox);

        eye = findViewById(R.id.eye);
        cnf_eye = findViewById(R.id.cnf_eye);

        et_user = findViewById(R.id.et_user);
        et_last_name = findViewById(R.id.et_last_name);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        cnf_et_pass = findViewById(R.id.cnf_et_pass);


        clicks();
    }

    void clicks() {


        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();
        });

        ll_terms.setOnClickListener((v) -> {
            if (isTermSelect) {
                img_checkbox.setBackgroundResource(R.drawable.check_off_box_icon);
            } else {
                img_checkbox.setBackgroundResource(R.drawable.check_box_icon);
            }
            isTermSelect = !isTermSelect;
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
        cnf_eye.setOnClickListener((v) -> {
            if (isCnfPasswordShow) {
                cnf_et_pass.setInputType(InputType.TYPE_CLASS_TEXT);
                cnf_et_pass.setTransformationMethod(null);
                cnf_eye.setBackgroundResource(R.drawable.eye_on_icon);
            } else {
                cnf_eye.setBackgroundResource(R.drawable.eye_off_icon);
                cnf_et_pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                cnf_et_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            isCnfPasswordShow = !isCnfPasswordShow;

        });


        findViewById(R.id.sign_up).setOnClickListener((v) -> {


            if (!TextUtils.isEmpty(et_user.getText().toString().trim())) {

                if (!TextUtils.isEmpty(et_last_name.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(et_email.getText().toString().trim())) {
                        if (Utils.isValidEmailId(et_email.getText().toString().trim())) {


                            if (!TextUtils.isEmpty(et_pass.getText().toString().trim())) {

                                if (!TextUtils.isEmpty(cnf_et_pass.getText().toString().trim())) {

                                    if (et_pass.getText().toString().trim().equals(cnf_et_pass.getText().toString().trim())) {
                                        startActivity(new Intent(SignupActivity.this, EnterOtpActivity.class));
                                        finishAffinity();

                                    } else {
                                        Toast.makeText(this, "Password Mismatched", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Toast.makeText(this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(this, "Please enter valid emai id", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter email id", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Please enter last name", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter first name", Toast.LENGTH_SHORT).show();
            }


        });


    }
}