package com.ve.lawyer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.ve.lawyer.R;
import com.ve.lawyer.activity.PostDetailActivity;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);
        }
    }


    public PostAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);

        itemView.setOnClickListener((v) -> {
            context.startActivity(new Intent(context, PostDetailActivity.class));
        });


        return new PostAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostAdapter.MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 5;
    }
}