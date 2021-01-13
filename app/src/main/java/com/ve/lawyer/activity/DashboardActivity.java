package com.ve.lawyer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.ve.lawyer.R;
import com.ve.lawyer.fragments.ContactFragment;
import com.ve.lawyer.fragments.NotificationFragment;
import com.ve.lawyer.fragments.QuestionFragment;
import com.ve.lawyer.utils.Utils;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout navDrawer;
    private NavigationView navigationView;
    private View headerView;
    private TextView title;


    private LinearLayout ll_dashBoard, ll_category, ll_change_password, ll_help, ll_term, ll_logout;
    private ImageView img_dashboard, img_category, img_password, img_help, img_term, img_logout;
    private TextView dashboard, category, change_pass, help, term, logout;

    private LinearLayout ll_question, ll_notification, ll_contact;
    private TextView tv_question, tv_notification, tv_contact;
    private ImageView img_question, img_notification, img_contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        navDrawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        title = findViewById(R.id.title);
        headerView = navigationView.getHeaderView(0);
        handleNavigation();
        handleBottomNavigation();


        clicks();
    }


    void clicks() {
        findViewById(R.id.menu).setOnClickListener((v) -> {
            if (!navDrawer.isDrawerOpen(GravityCompat.START))
                navDrawer.openDrawer(GravityCompat.START);
            else navDrawer.closeDrawer(GravityCompat.END);

        });


    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 1) {
            finishAffinity();
        }
    }

    void handleNavigation() {
        ll_dashBoard = headerView.findViewById(R.id.ll_dashBoard);
        ll_category = headerView.findViewById(R.id.ll_category);
        ll_change_password = headerView.findViewById(R.id.ll_change_password);
        ll_help = headerView.findViewById(R.id.ll_help);
        ll_term = headerView.findViewById(R.id.ll_term);
        ll_logout = headerView.findViewById(R.id.ll_logout);


        img_dashboard = headerView.findViewById(R.id.img_dashboard);
        img_category = headerView.findViewById(R.id.img_category);
        img_password = headerView.findViewById(R.id.img_password);
        img_help = headerView.findViewById(R.id.img_help);
        img_term = headerView.findViewById(R.id.img_term);
        img_logout = headerView.findViewById(R.id.img_logout);


        dashboard = headerView.findViewById(R.id.dashboard);
        category = headerView.findViewById(R.id.category);
        change_pass = headerView.findViewById(R.id.change_pass);
        help = headerView.findViewById(R.id.help);
        term = headerView.findViewById(R.id.term);
        logout = headerView.findViewById(R.id.logout);

        ll_dashBoard.setOnClickListener((v) -> {
            ll_dashBoard.setBackgroundColor(getResources().getColor(R.color.blue_alpha));
            ll_category.setBackgroundColor(getResources().getColor(R.color.white));
            ll_change_password.setBackgroundColor(getResources().getColor(R.color.white));
            ll_help.setBackgroundColor(getResources().getColor(R.color.white));
            ll_term.setBackgroundColor(getResources().getColor(R.color.white));
            ll_logout.setBackgroundColor(getResources().getColor(R.color.white));

            dashboard.setTextColor(getResources().getColor(R.color.blue_fb));
            category.setTextColor(getResources().getColor(R.color.default_text_color));
            change_pass.setTextColor(getResources().getColor(R.color.default_text_color));
            help.setTextColor(getResources().getColor(R.color.default_text_color));
            term.setTextColor(getResources().getColor(R.color.default_text_color));
            logout.setTextColor(getResources().getColor(R.color.default_text_color));


        });
        ll_category.setOnClickListener((v) -> {
            ll_category.setBackgroundColor(getResources().getColor(R.color.blue_alpha));
            ll_dashBoard.setBackgroundColor(getResources().getColor(R.color.white));
            ll_change_password.setBackgroundColor(getResources().getColor(R.color.white));
            ll_help.setBackgroundColor(getResources().getColor(R.color.white));
            ll_term.setBackgroundColor(getResources().getColor(R.color.white));
            ll_logout.setBackgroundColor(getResources().getColor(R.color.white));

            dashboard.setTextColor(getResources().getColor(R.color.default_text_color));
            category.setTextColor(getResources().getColor(R.color.blue_fb));
            change_pass.setTextColor(getResources().getColor(R.color.default_text_color));
            help.setTextColor(getResources().getColor(R.color.default_text_color));
            term.setTextColor(getResources().getColor(R.color.default_text_color));
            logout.setTextColor(getResources().getColor(R.color.default_text_color));


        });
        ll_change_password.setOnClickListener((v) -> {
            ll_change_password.setBackgroundColor(getResources().getColor(R.color.blue_alpha));
            ll_category.setBackgroundColor(getResources().getColor(R.color.white));
            ll_dashBoard.setBackgroundColor(getResources().getColor(R.color.white));
            ll_help.setBackgroundColor(getResources().getColor(R.color.white));
            ll_term.setBackgroundColor(getResources().getColor(R.color.white));
            ll_logout.setBackgroundColor(getResources().getColor(R.color.white));

            dashboard.setTextColor(getResources().getColor(R.color.default_text_color));
            category.setTextColor(getResources().getColor(R.color.default_text_color));
            change_pass.setTextColor(getResources().getColor(R.color.blue_fb));
            help.setTextColor(getResources().getColor(R.color.default_text_color));
            term.setTextColor(getResources().getColor(R.color.default_text_color));
            logout.setTextColor(getResources().getColor(R.color.default_text_color));


        });
        ll_help.setOnClickListener((v) -> {
            ll_help.setBackgroundColor(getResources().getColor(R.color.blue_alpha));
            ll_change_password.setBackgroundColor(getResources().getColor(R.color.white));
            ll_category.setBackgroundColor(getResources().getColor(R.color.white));
            ll_dashBoard.setBackgroundColor(getResources().getColor(R.color.white));
            ll_term.setBackgroundColor(getResources().getColor(R.color.white));
            ll_logout.setBackgroundColor(getResources().getColor(R.color.white));

            dashboard.setTextColor(getResources().getColor(R.color.default_text_color));
            category.setTextColor(getResources().getColor(R.color.default_text_color));
            change_pass.setTextColor(getResources().getColor(R.color.default_text_color));
            help.setTextColor(getResources().getColor(R.color.blue_fb));
            term.setTextColor(getResources().getColor(R.color.default_text_color));
            logout.setTextColor(getResources().getColor(R.color.default_text_color));

        });
        ll_term.setOnClickListener((v) -> {
            ll_term.setBackgroundColor(getResources().getColor(R.color.blue_alpha));
            ll_help.setBackgroundColor(getResources().getColor(R.color.white));
            ll_change_password.setBackgroundColor(getResources().getColor(R.color.white));
            ll_category.setBackgroundColor(getResources().getColor(R.color.white));
            ll_dashBoard.setBackgroundColor(getResources().getColor(R.color.white));
            ll_logout.setBackgroundColor(getResources().getColor(R.color.white));


            dashboard.setTextColor(getResources().getColor(R.color.default_text_color));
            category.setTextColor(getResources().getColor(R.color.default_text_color));
            change_pass.setTextColor(getResources().getColor(R.color.default_text_color));
            help.setTextColor(getResources().getColor(R.color.default_text_color));
            term.setTextColor(getResources().getColor(R.color.blue_fb));
            logout.setTextColor(getResources().getColor(R.color.default_text_color));

        });
        ll_logout.setOnClickListener((v) -> {
            ll_logout.setBackgroundColor(getResources().getColor(R.color.blue_alpha));
            ll_term.setBackgroundColor(getResources().getColor(R.color.white));
            ll_help.setBackgroundColor(getResources().getColor(R.color.white));
            ll_change_password.setBackgroundColor(getResources().getColor(R.color.white));
            ll_category.setBackgroundColor(getResources().getColor(R.color.white));
            ll_dashBoard.setBackgroundColor(getResources().getColor(R.color.white));

            dashboard.setTextColor(getResources().getColor(R.color.default_text_color));
            category.setTextColor(getResources().getColor(R.color.default_text_color));
            change_pass.setTextColor(getResources().getColor(R.color.default_text_color));
            help.setTextColor(getResources().getColor(R.color.default_text_color));
            term.setTextColor(getResources().getColor(R.color.default_text_color));
            logout.setTextColor(getResources().getColor(R.color.blue_fb));

        });

    }

    void handleBottomNavigation() {

        ll_question = findViewById(R.id.ll_question);
        ll_notification = findViewById(R.id.ll_notification);
        ll_contact = findViewById(R.id.ll_contact);


        tv_question = findViewById(R.id.tv_question);
        tv_notification = findViewById(R.id.tv_notification);
        tv_contact = findViewById(R.id.tv_contact);

        img_question = findViewById(R.id.img_question);
        img_notification = findViewById(R.id.img_notification);
        img_contact = findViewById(R.id.img_contact);


        ll_question.setOnClickListener((v) -> {
            img_question.setBackgroundResource(R.drawable.q_on_icon);
            tv_question.setTextColor(getResources().getColor(R.color.blue_fb));


            img_notification.setBackgroundResource(R.drawable.notification_off_icon);
            tv_notification.setTextColor(getResources().getColor(R.color.default_text_color));


            img_contact.setBackgroundResource(R.drawable.contact_off_icon);
            tv_contact.setTextColor(getResources().getColor(R.color.default_text_color));

            Utils.replaceFragment(this, R.id.container, new QuestionFragment());
            title.setText("Post Question");


        });
        ll_notification.setOnClickListener((v) -> {

            img_question.setBackgroundResource(R.drawable.q_off_icon);
            tv_question.setTextColor(getResources().getColor(R.color.default_text_color));


            img_notification.setBackgroundResource(R.drawable.notification_on_icon);
            tv_notification.setTextColor(getResources().getColor(R.color.blue_fb));


            img_contact.setBackgroundResource(R.drawable.contact_off_icon);
            tv_contact.setTextColor(getResources().getColor(R.color.default_text_color));
            Utils.replaceFragment(this, R.id.container, new NotificationFragment());
            title.setText("Notification");
        });
        ll_contact.setOnClickListener((v) -> {

            img_question.setBackgroundResource(R.drawable.q_off_icon);
            tv_question.setTextColor(getResources().getColor(R.color.default_text_color));


            img_notification.setBackgroundResource(R.drawable.notification_off_icon);
            tv_notification.setTextColor(getResources().getColor(R.color.default_text_color));


            img_contact.setBackgroundResource(R.drawable.contact_on_icon);
            tv_contact.setTextColor(getResources().getColor(R.color.blue_fb));
            Utils.replaceFragment(this, R.id.container, new ContactFragment());
            title.setText("Contact");
        });

        Utils.replaceFragment(this, R.id.container, new QuestionFragment());
        title.setText("Post Question");


    }

}