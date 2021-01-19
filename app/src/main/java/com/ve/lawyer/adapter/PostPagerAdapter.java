package com.ve.lawyer.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ve.lawyer.fragments.AllPostFragment;
import com.ve.lawyer.fragments.MyPostFragment;

public class PostPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PostPagerAdapter(FragmentManager fm, int NoofTabs) {
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AllPostFragment home = new AllPostFragment();
                return home;
            case 1:
                MyPostFragment about = new MyPostFragment();
                return about;

            default:
                return null;
        }
    }
}