package com.example.mirand.controllers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.mirand.util.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserController {
    // TODO: ДОБАВИТЬ ССЫЛКУ НА НАШ ЛОКАЛЬНЫЙ СЕРВЕР
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        UserAPI userAPI = retrofit.create(UserAPI.class);

        Call<User> call = userAPI.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()) {
                    Log.e("UserAPI", "Code: " + response.message());
                }

                User user = response.body();

                Log.i("UserAPI", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("UserAPI", t.getMessage(), t);
            }
        });
    }


}
