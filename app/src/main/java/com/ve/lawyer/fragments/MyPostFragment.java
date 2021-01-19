package com.ve.lawyer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ve.lawyer.R;
import com.ve.lawyer.adapter.PostAdapter;

public class MyPostFragment extends Fragment {

    RecyclerView rv_post;
    View main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        main = inflater.inflate(R.layout.fragment_my_post, container, false);
        rv_post = main.findViewById(R.id.rv_post);

        rv_post.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_post.setAdapter(new PostAdapter(getActivity()));

        return main;
    }
}