package com.ve.lawyer.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ve.lawyer.R;
import com.ve.lawyer.activity.CreateNewPostActivity;


public class QuestionFragment extends Fragment {

    private View main;

    private ImageView attachment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.fragment_question, container, false);
        attachment = main.findViewById(R.id.attachment);
        setCLicks();
        return main;

    }

    void setCLicks() {
        attachment.setOnClickListener((v) -> {

            startActivity(new Intent(getActivity(), CreateNewPostActivity.class));
        });

    }
}