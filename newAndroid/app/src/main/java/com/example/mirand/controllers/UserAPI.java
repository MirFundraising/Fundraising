package com.example.mirand.controllers;

import com.example.mirand.util.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAPI {
    @GET("user")
    Call<User> getUser();
}
