package com.playmarket.gloolgle.site_v1_android;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    ListView listview;
    String url  = "http://192.168.1.104:8000/";

    Retrofit builder = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    interfaceAPI interfaceAPI = builder.create(interfaceAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listview  =(ListView)findViewById(R.id.listViews);

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
            }

        });
    }

    @Override
    public void onRefresh() {

    }
}
