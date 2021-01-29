package com.ve.lawyer.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.ve.lawyer.R;

public class CreateNewPostActivity extends AppCompatActivity {

    private EditText edit_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_post);
        edit_query = findViewById(R.id.edit_query);
        clicks();
    }


    void clicks() {
        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();


        });
        findViewById(R.id.post).setOnClickListener((v) -> {
            if (!TextUtils.isEmpty(edit_query.getText().toString().trim())) {
                Toast.makeText(this, "Your question posted successfully.", Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(CreateNewPostActivity.this, MyPostActivity.class);
                mIntent.putExtra("openCat", true);
                startActivity(mIntent);
                finish();
            } else {

                Toast.makeText(this, "Please type the text", Toast.LENGTH_SHORT).show();
            }

        });
    }


}