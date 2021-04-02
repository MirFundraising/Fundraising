package com.example.mirand.controllers;

import android.util.Log;

import com.example.mirand.util.Cluster;
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
    private UserAPI userAPI;
    private User user;
    private User userResponse;
    private List<User> clusterUsers;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        userAPI = retrofit.create(UserAPI.class);
    }

    public User getUserByPhone(Cluster cluster, String phone) {
        if(userAPI == null) {
            start();
        }
        Call<User> call = userAPI.getUserByPhone(phone, cluster);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Log.e("UserAPI", "Code: " + response.message());
                }

                user = response.body();
                Log.i("UserAPI", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("UserAPI", t.getMessage(), t);
            }
        });
        return user;
    }

    public List<User> getClusterUsers(Cluster cluster) {
        if(userAPI == null) {
            start();
        }

        Call<List<User>> call = userAPI.getClusterUsers(cluster);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    Log.e("UserAPI", "Code: " + response.message());
                }

                clusterUsers = response.body();
                Log.i("UserAPI", user.toString());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("UserAPI", t.getMessage(), t);
            }
        });

        return clusterUsers;
    }

    public User createNewUser(Cluster cluster, User user) {
        if(userAPI == null) {
            start();
        }

        Call<User> call = userAPI.createNewUser(user, cluster);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    Log.e("UserAPI", "Code: " + response.message());
                    return;
                }

                userResponse = response.body();
                Log.i("UserAPI", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("UserAPI", t.getMessage(), t);
            }
        });

        return userResponse;
    }
}
