package com.ve.lawyer.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ve.lawyer.R;
import com.ve.lawyer.adapter.ChatAdapter;
import com.ve.lawyer.model.ChatModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {
    private ChatAdapter ca;
    private ArrayList<ChatModel> listChat;
    private RecyclerView rv_chat;
    private ImageView iv_smily;
    private EditText et_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        rv_chat = findViewById(R.id.rv_chat);
        iv_smily = findViewById(R.id.iv_smily);
        et_message = findViewById(R.id.et_message);
        rv_chat.setLayoutManager(new LinearLayoutManager(this));
        clicks();
        dummy();
    }

    void clicks() {
        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();

        });
        iv_smily.setOnClickListener((v) -> {
            if (et_message.getText().toString().trim().length() > 0) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
                ChatModel cm = new ChatModel();
                cm.setFromId("1");
                cm.setMessage(et_message.getText().toString().trim());
                cm.setName("Rahul");
                cm.setTime(dateFormat.format(new Date()));
                listChat.add(cm);
                ca.notifyDataSetChanged();
                rv_chat.smoothScrollToPosition(listChat.size());
                et_message.setText("");

            } else {
                Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show();
            }

        });
    }


    void dummy() {
        listChat = new ArrayList<>();


        ChatModel cm;


        cm = new ChatModel();
        cm.setFromId("2");
        cm.setMessage("Hi");
        cm.setName("User");
        cm.setTime("9:30 AM");
        listChat.add(cm);

        cm = new ChatModel();
        cm.setFromId("1");
        cm.setMessage("Hello, How are you");
        cm.setName("User");
        cm.setTime("9:31 AM");
        listChat.add(cm);


        ca = new ChatAdapter(this, listChat);
        rv_chat.setAdapter(ca);


    }
}