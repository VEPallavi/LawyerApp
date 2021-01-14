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
import com.ve.lawyer.activity.InviteUserActivity;
import com.ve.lawyer.model.ContactModel;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyViewHolder> {

    private ArrayList<ContactModel> moviesList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public ConstraintLayout item;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            image = (ImageView) view.findViewById(R.id.image);
            item = (ConstraintLayout) view.findViewById(R.id.item);
        }
    }


    public ContactListAdapter(Context context, ArrayList<ContactModel> moviesList) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ContactModel movie = moviesList.get(position);
        holder.name.setText(movie.getName());
        holder.item.setOnClickListener((v) -> {
            Intent in = new Intent(context, InviteUserActivity.class);
            in.putExtra("user", moviesList.get(position).getName());
            context.startActivity(in);
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}