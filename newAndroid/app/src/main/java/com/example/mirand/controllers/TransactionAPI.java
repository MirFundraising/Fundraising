package com.example.mirand.controllers;

import com.example.mirand.util.Cluster;
import com.example.mirand.util.Fundraising;
import com.example.mirand.util.Transaction;
import com.example.mirand.util.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TransactionAPI {
    @GET("transaction")
    Call<List<Transaction>> getFundraisingTransactionList(
            @Query("fundraising") Fundraising fundraising);

    @GET("transaction/{id}/")
    Call<Transaction> getTransactionById(@Path("id") String id,
                                         @Query("fundraising") Fundraising fundraising);

    @POST("transaction")
    Call<Transaction> createNewTransaction(@Body Transaction transaction,
                                           @Body Fundraising fundraising);
}
