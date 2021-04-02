package com.example.mirand.controllers;

import com.example.mirand.util.CreditCard;
import com.example.mirand.util.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CardAPI {
    @GET("card")
    Call<List<CreditCard>> getUserCardList(@Query("user") User user);

    @GET("card/{creditCardNumber}")
    Call<CreditCard> getUserCardById(@Path("creditCardNumber") String creditCardNumber);

    @POST("card")
    Call<CreditCard> addNewUserCard(@Body CreditCard creditCard);
}
