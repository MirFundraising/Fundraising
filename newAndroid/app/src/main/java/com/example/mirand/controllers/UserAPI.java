package com.example.mirand.controllers;

import com.example.mirand.util.Cluster;
import com.example.mirand.util.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserAPI {
    @GET("user")
    Call<List<User>> getClusterUsers(@Query("cluster") Cluster cluster);

    @GET("user/{phone}/")
    Call<User> getUserByPhone(@Path("phone") String phone, @Query("cluster")Cluster cluster);

    @POST("user")
    Call<User> createNewUser(@Body User user, @Body Cluster cluster);
}
