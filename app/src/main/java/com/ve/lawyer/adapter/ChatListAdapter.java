package com.ve.lawyer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ve.lawyer.R;
import com.ve.lawyer.activity.ChatActivity;
import com.ve.lawyer.model.ChatModel;
import com.ve.lawyer.model.ContactModel;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ChatModel> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView name;
        public TextView last_msg;
        public TextView last_msg_time;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            last_msg_time = (TextView) view.findViewById(R.id.last_msg_time);
            last_msg = (TextView) view.findViewById(R.id.last_msg);
        }
    }


    public ChatListAdapter(Context context, ArrayList<ChatModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ChatListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_list, parent, false);
        itemView.setOnClickListener((v) -> {
            context.startActivity(new Intent(context, ChatActivity.class));
        });


        return new ChatListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatListAdapter.MyViewHolder holder, int position) {
        holder.last_msg.setText(list.get(position).getMessage());
        holder.name.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}