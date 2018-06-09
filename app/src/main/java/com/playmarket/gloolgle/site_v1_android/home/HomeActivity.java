package com.playmarket.gloolgle.site_v1_android.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.playmarket.gloolgle.site_v1_android.PostAdapter;
import util.PostsGetSet;
import com.playmarket.gloolgle.site_v1_android.R;
import com.playmarket.gloolgle.site_v1_android.interfaceAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import util.bottomnavigationHelper;


public class HomeActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private static final String Tag = "HomeActivity";
    private static final int ACTIVITY_NUM = 0;
    private Context mContext = HomeActivity.this;

    ListView listview;
    String url  = "http://192.168.1.104:8000/";
    TextView CallPhoneNumber;;
    Retrofit builder = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    com.playmarket.gloolgle.site_v1_android.interfaceAPI interfaceAPI = builder.create(interfaceAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(Tag, "onCreate: string.");
        listview  =(ListView)findViewById(R.id.listViews);

//        setupBottomNavigationView();
        ResponseData();
        final SwipeRefreshLayout swipeRefreshLayout  = (SwipeRefreshLayout)findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        ResponseData();
                    }
                }, 3000);
            }
        });


    }
    public void ResponseData(){
        Call<List<PostsGetSet>> call = interfaceAPI.Post("post", "");
        call.enqueue(new Callback<List<PostsGetSet>>() {
            @Override
            public void onResponse(Call<List<PostsGetSet>> call, Response<List<PostsGetSet>> response) {
                List<PostsGetSet> body = response.body();
                if (response.isSuccessful()){
                    listview.setAdapter(new PostAdapter(HomeActivity.this, body));
                    Toast.makeText(HomeActivity.this, "its responsed success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(HomeActivity.this, "no response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PostsGetSet>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Errer ==> " + t, Toast.LENGTH_SHORT).show();
                Log.e("Error to response ", t.getMessage());
            }

        });
    }

    @Override
    public void onRefresh() {

    }

//    public void setupBottomNavigationView(){
//        Log.d(Tag, "setupBottomNavigationView");
//        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);
//        bottomnavigationHelper.setupBottomNavView(bottomNavigationViewEx);
//        bottomnavigationHelper.enableNavigation(HomeActivity.this, bottomNavigationViewEx);
//        Menu menu = bottomNavigationViewEx.getMenu();
//        MenuItem mitem = menu.getItem(ACTIVITY_NUM);
//        mitem.setChecked(true);
//    }
}
