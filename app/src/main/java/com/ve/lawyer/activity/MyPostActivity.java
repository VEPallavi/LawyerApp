package com.ve.lawyer.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ve.lawyer.R;
import com.ve.lawyer.adapter.PostPagerAdapter;

public class MyPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post);
        clicks();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("All Post"));
        tabLayout.addTab(tabLayout.newTab().setText("My Post"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        PostPagerAdapter tabsAdapter = new PostPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    void clicks() {

        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();


        });

    }
}