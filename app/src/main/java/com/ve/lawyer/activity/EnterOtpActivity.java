package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ve.lawyer.R;

public class EnterOtpActivity extends AppCompatActivity {
    EditText otp1, otp2, otp3, otp4;
    TextView timer, resend, txt_invalid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        timer = findViewById(R.id.timer);
        resend = findViewById(R.id.resend);
        txt_invalid = findViewById(R.id.txt_invalid);
        listen();
        clicks();
    }

    void clicks() {
        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();

        });

        findViewById(R.id.next).setOnClickListener((v) -> {
            String otp = otp1.getText().toString().trim() + otp2.getText().toString().trim() + otp3.getText().toString().trim() + otp4.getText().toString().trim();
            if (otp.length() == 4) {
                startActivity(new Intent(EnterOtpActivity.this, DashboardActivity.class));
                finishAffinity();
            } else {
                Toast.makeText(this, "Please enter 4 digit otp", Toast.LENGTH_SHORT).show();
            }

        });
        resend.setOnClickListener((v) -> {
            timer.setVisibility(View.VISIBLE);
            resend.setVisibility(View.GONE);
            startTimer();

        });
        startTimer();

    }


    void startTimer() {
        new CountDownTimer(60 * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(millisUntilFinished / 1000 + "");
            }

            public void onFinish() {

                timer.setVisibility(View.GONE);
                resend.setVisibility(View.VISIBLE);


            }

        }.start();
    }

    void listen() {

        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() > 0) {
                    otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() > 0) {
                    otp3.requestFocus();
                }
                if (count == 0) {
                    otp1.requestFocus(1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() > 0) {
                    otp4.requestFocus();
                }
                if (count == 0) {
                    otp2.requestFocus(1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (count == 0) {
                    otp3.requestFocus(1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}