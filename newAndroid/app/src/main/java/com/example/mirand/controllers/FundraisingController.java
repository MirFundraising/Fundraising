package com.example.mirand.controllers;

import android.util.Log;

import com.example.mirand.util.Cluster;
import com.example.mirand.util.Fundraising;
import com.example.mirand.util.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class FundraisingController {
    // TODO: ДОБАВИТЬ ССЫЛКУ НА НАШ ЛОКАЛЬНЫЙ СЕРВЕР
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private FundraisingAPI fundraisingAPI;
    private Fundraising fundraising;
    private Fundraising fundraisingResponse;
    private List<Fundraising> fundraisingClusters;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        fundraisingAPI = retrofit.create(FundraisingAPI.class);
    }

    List<Fundraising> getFundraisingListOfCluster(Cluster cluster) {
        if(fundraisingAPI == null) {
            start();
        }
        Call<List<Fundraising>> call = fundraisingAPI.getFundraisingListOfCluster(cluster);
        call.enqueue(new Callback<List<Fundraising>>() {
            @Override
            public void onResponse(Call<List<Fundraising>> call,
                                   Response<List<Fundraising>> response) {
                if (!response.isSuccessful()) {
                    Log.e("FundraisingAPI", "Code: " + response.message());
                }

                fundraisingClusters = response.body();
                Log.i("FundraisingAPI", fundraisingClusters.toString());
            }

            @Override
            public void onFailure(Call<List<Fundraising>> call, Throwable t) {
                Log.e("FundraisingAPI", t.getMessage(), t);
            }
        });
        return fundraisingClusters;
    }


    Fundraising getFundraisingById(String id, Cluster cluster) {
        if(fundraisingAPI == null) {
            start();
        }
        Call<Fundraising> call = fundraisingAPI.getFundraisingById(id, cluster);
        call.enqueue(new Callback<Fundraising>() {
            @Override
            public void onResponse(Call<Fundraising> call,
                                   Response<Fundraising> response) {
                if (!response.isSuccessful()) {
                    Log.e("FundraisingAPI", "Code: " + response.message());
                }

                fundraising = response.body();
                Log.i("FundraisingAPI", fundraisingClusters.toString());
            }

            @Override
            public void onFailure(Call<Fundraising> call, Throwable t) {
                Log.e("FundraisingAPI", t.getMessage(), t);
            }
        });
        return fundraising;
    }

    Fundraising createNewFundraising(Fundraising fundraising, Cluster cluster) {
        if(fundraisingAPI == null) {
            start();
        }
        Call<Fundraising> call = fundraisingAPI.createNewFundraising(fundraising, cluster);
        call.enqueue(new Callback<Fundraising>() {
            @Override
            public void onResponse(Call<Fundraising> call,
                                   Response<Fundraising> response) {
                if (!response.isSuccessful()) {
                    Log.e("FundraisingAPI", "Code: " + response.message());
                }

                fundraisingResponse = response.body();
                Log.i("FundraisingAPI", fundraisingClusters.toString());
            }

            @Override
            public void onFailure(Call<Fundraising> call, Throwable t) {
                Log.e("FundraisingAPI", t.getMessage(), t);
            }
        });

        return fundraisingResponse;
    }

    Fundraising changeFundraisingCurrentFunds(String id, Fundraising fundraising, Cluster cluster) {
        if(fundraisingAPI == null) {
            start();
        }
        Call<Fundraising> call = fundraisingAPI.changeFundraisingCurrentFunds(id, fundraising,
                cluster);
        call.enqueue(new Callback<Fundraising>() {
            @Override
            public void onResponse(Call<Fundraising> call,
                                   Response<Fundraising> response) {
                if (!response.isSuccessful()) {
                    Log.e("FundraisingAPI", "Code: " + response.message());
                }

                fundraisingResponse = response.body();
                Log.i("FundraisingAPI", fundraisingClusters.toString());
            }

            @Override
            public void onFailure(Call<Fundraising> call, Throwable t) {
                Log.e("FundraisingAPI", t.getMessage(), t);
            }
        });

        return fundraisingResponse;
    }
}
