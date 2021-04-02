package com.example.mirand.controllers;

import android.util.Log;

import com.example.mirand.util.Fundraising;
import com.example.mirand.util.Transaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TransactionController {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private TransactionAPI transactionAPI;
    private Transaction transaction;
    private Transaction transactionResponse;
    private List<Transaction> clusterUsers;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        transactionAPI = retrofit.create(TransactionAPI.class);
    }

    public List<Transaction> getUserByPhone(Fundraising fundraising) {
        if(transactionAPI == null) {
            start();
        }
        Call<List<Transaction>> call = transactionAPI.getFundraisingTransactionList(fundraising);
        call.enqueue(new Callback<List<Transaction>>() {
            @Override
            public void onResponse(Call<List<Transaction>> call,
                                   Response<List<Transaction>> response) {
                if (!response.isSuccessful()) {
                    Log.e("TransactionAPI", "Code: " + response.message());
                }

                clusterUsers = response.body();
                Log.i("TransactionAPI", clusterUsers.toString());
            }

            @Override
            public void onFailure(Call<List<Transaction>> call, Throwable t) {
                Log.e("TransactionAPI", t.getMessage(), t);
            }
        });

        return clusterUsers;
    }

    public Transaction getTransactionById(String id, Fundraising fundraising) {
        if(transactionAPI == null) {
            start();
        }
        Call<Transaction> call = transactionAPI.getTransactionById(id, fundraising);
        call.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call,
                                   Response<Transaction> response) {
                if (!response.isSuccessful()) {
                    Log.e("TransactionAPI", "Code: " + response.message());
                }

                transaction = response.body();
                Log.i("TransactionAPI", transaction.toString());
            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {
                Log.e("TransactionAPI", t.getMessage(), t);
            }
        });

        return transaction;
    }

    public Transaction createNewTransaction(Transaction transaction, Fundraising fundraising){
        if(transactionAPI == null) {
            start();
        }
        Call<Transaction> call = transactionAPI.createNewTransaction(transaction, fundraising);
        call.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call,
                                   Response<Transaction> response) {
                if (!response.isSuccessful()) {
                    Log.e("TransactionAPI", "Code: " + response.message());
                }

                transactionResponse = response.body();
                Log.i("TransactionAPI", transactionResponse.toString());
            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {
                Log.e("TransactionAPI", t.getMessage(), t);
            }
        });

        return transactionResponse;
    }
}
