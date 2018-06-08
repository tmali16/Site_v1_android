package com.playmarket.gloolgle.site_v1_android.profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.playmarket.gloolgle.site_v1_android.R;

import util.bottomnavigationHelper;

public class ProfileActivity extends AppCompatActivity{
    private static final String Tag = "ProfileActivity";
    private static final int ACTIVITY_NUM = 1;
    private Context mContext = ProfileActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(Tag, "onCreate: started");

    }

    public void setupBottomNavigationView(){
        Log.d(Tag, "setupBottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);
        bottomnavigationHelper.setupBottomNavView(bottomNavigationViewEx);
        bottomnavigationHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem mitem = menu.getItem(ACTIVITY_NUM);
        mitem.setChecked(true);
    }
}
