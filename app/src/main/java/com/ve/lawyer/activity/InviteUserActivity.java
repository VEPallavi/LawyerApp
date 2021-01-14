package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ve.lawyer.R;

public class InviteUserActivity extends AppCompatActivity {

    private EditText edit_query;
    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_user);
        edit_query = findViewById(R.id.edit_query);
        userName = findViewById(R.id.userName);

        userName.setText(getIntent().getStringExtra("user"));
        setClicks();
    }

    void setClicks() {
        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();

        });

        findViewById(R.id.invite).setOnClickListener((v) -> {
            if (!TextUtils.isEmpty(edit_query.getText().toString().trim())) {

                Toast.makeText(this, "Invite success", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Please enter message ", Toast.LENGTH_SHORT).show();
            }

        });

    }
}