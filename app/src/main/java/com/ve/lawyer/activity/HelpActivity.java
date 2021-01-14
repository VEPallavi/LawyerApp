package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.ve.lawyer.R;

public class HelpActivity extends AppCompatActivity {


    private EditText issue, write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        issue = findViewById(R.id.issue);
        write = findViewById(R.id.write);
        setClick();
    }


    void setClick() {
        findViewById(R.id.submit).setOnClickListener((v) -> {

            if (!TextUtils.isEmpty(issue.getText().toString().trim())) {
                if (!TextUtils.isEmpty(write.getText().toString().trim())) {
                    Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Please enter the note", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter the issue", Toast.LENGTH_SHORT).show();
            }

        });

        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();

        });

    }
}