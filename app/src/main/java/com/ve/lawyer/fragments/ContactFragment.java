package com.ve.lawyer.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ve.lawyer.R;
import com.ve.lawyer.activity.MyContactList;


public class ContactFragment extends Fragment {

    private View main;
    private TextView invite;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        main = inflater.inflate(R.layout.fragment_contact, container, false);
        invite = main.findViewById(R.id.invite);
        setClicks();
        return main;
    }

    void setClicks() {
        invite.setOnClickListener((v) -> {

            startActivity(new Intent(getActivity(), MyContactList.class));
        });

    }
}