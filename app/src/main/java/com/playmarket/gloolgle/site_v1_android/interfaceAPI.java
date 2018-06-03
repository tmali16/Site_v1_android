package com.playmarket.gloolgle.site_v1_android;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface interfaceAPI {
    @GET("api/{obj}/{id}")
    Call<List<PostsGetSet>>Post(@Path("obj")String obj, @Path("id")String id);

    @GET("api/post/{id}")
    Call<List<ServicesGetSet>>Services(@Path("id")String user);
}
