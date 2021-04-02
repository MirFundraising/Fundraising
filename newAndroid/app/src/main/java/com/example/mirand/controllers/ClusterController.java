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

public class ClusterController {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ClusterAPI clusterAPI;
    private Cluster cluster;
    private Cluster clusterResponse;
    private User userResponse;
    private List<Cluster> userClusters;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        clusterAPI = retrofit.create(ClusterAPI.class);
    }

    public List<Cluster> getUserClusterList(User user) {
        if (clusterAPI == null) {
            start();
        }
        Call<List<Cluster>> call = clusterAPI.getUserClusterList(user);
        call.enqueue(new Callback<List<Cluster>>() {
            @Override
            public void onResponse(Call<List<Cluster>> call, Response<List<Cluster>> response) {
                if (!response.isSuccessful()) {
                    Log.e("ClusterAPI", "Code: " + response.message());
                }

                userClusters = response.body();
                Log.i("ClusterAPI", userClusters.toString());
            }

            @Override
            public void onFailure(Call<List<Cluster>> call, Throwable t) {
                Log.e("ClusterAPI", t.getMessage(), t);
            }
        });
        return userClusters;
    }

    public Cluster getUserClusterByClusterName(String clusterName, User user) {
        if (clusterAPI == null) {
            start();
        }
        Call<Cluster> call = clusterAPI.getUserClusterByClusterName(clusterName, user);
        call.enqueue(new Callback<Cluster>() {
            @Override
            public void onResponse(Call<Cluster> call, Response<Cluster> response) {
                if (!response.isSuccessful()) {
                    Log.e("ClusterAPI", "Code: " + response.message());
                    return;
                }

                cluster = response.body();
                Log.i("ClusterAPI", cluster.toString());
            }

            @Override
            public void onFailure(Call<Cluster> call, Throwable t) {
                Log.e("ClusterAPI", t.getMessage(), t);
                return;
            }
        });
        return cluster;
    }

    public Cluster createNewUserCluster(User user, Cluster cluster) {
        if (clusterAPI == null) {
            start();
        }
        Call<Cluster> call = clusterAPI.createNewUserCluster(user, cluster);
        call.enqueue(new Callback<Cluster>() {
            @Override
            public void onResponse(Call<Cluster> call, Response<Cluster> response) {
                if (!response.isSuccessful()) {
                    Log.e("ClusterAPI", "Code: " + response.message());
                    return;
                }

                clusterResponse = response.body();
                Log.i("ClusterAPI", clusterResponse.toString());
            }

            @Override
            public void onFailure(Call<Cluster> call, Throwable t) {
                Log.e("ClusterAPI", t.getMessage(), t);
                return;
            }
        });
        return clusterResponse;
    }

    public User addNewMemberToCluster(String name, User user, Cluster cluster) {
        if (clusterAPI == null) {
            start();
        }
        Call<User> call = clusterAPI.addNewMemberToCluster(name, user, cluster);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Log.e("ClusterAPI", "Code: " + response.message());
                    return;
                }

                userResponse = response.body();
                Log.i("ClusterAPI", clusterResponse.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ClusterAPI", t.getMessage(), t);
            }
        });

        return userResponse;
    }
}
