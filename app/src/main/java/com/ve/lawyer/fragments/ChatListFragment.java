package com.ve.lawyer.fragments;

import android.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ve.lawyer.R;
import com.ve.lawyer.adapter.ChatListAdapter;
import com.ve.lawyer.model.ChatModel;

import java.util.ArrayList;

public class ChatListFragment extends Fragment {


    View main;
    private RecyclerView rv_chat;
    ArrayList<ChatModel> chatlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        main = inflater.inflate(R.layout.fragment_chat_list, container, false);

        rv_chat = main.findViewById(R.id.rv_chat);
        rv_chat.setLayoutManager(new LinearLayoutManager(getActivity()));
        initDummy();
        return main;
    }


    void initDummy() {

        chatlist = new ArrayList<>();


        ChatModel cm;

        cm = new ChatModel();
        cm.setName("Rohit");
        cm.setMessage("Hi");
        chatlist.add(cm);

        cm = new ChatModel();
        cm.setName("Salman");
        cm.setMessage("Hello");
        chatlist.add(cm);


        cm = new ChatModel();
        cm.setName("Rahul");
        cm.setMessage("How are you");
        chatlist.add(cm);

        ChatListAdapter ad = new ChatListAdapter(getActivity(), chatlist);

        rv_chat.setAdapter(ad);


    }

}