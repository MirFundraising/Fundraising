package com.example.mirand.controllers;

import android.util.Log;

import com.example.mirand.util.CreditCard;
import com.example.mirand.util.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardController {
    // TODO: ДОБАВИТЬ ССЫЛКУ НА НАШ ЛОКАЛЬНЫЙ СЕРВЕР
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private CardAPI cardAPI;
    private CreditCard creditCard;
    private CreditCard creditCardResponse;
    private List<CreditCard> userCards;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        cardAPI = retrofit.create(CardAPI.class);
    }

    List<CreditCard> getUserCardList(User user) {
        if(cardAPI == null) {
            start();
        }
        Call<List<CreditCard>> call = cardAPI.getUserCardList(user);
        call.enqueue(new Callback<List<CreditCard>>() {
            @Override
            public void onResponse(Call<List<CreditCard>> call, Response<List<CreditCard>> response) {
                if (!response.isSuccessful()) {
                    Log.e("CardAPI", "Code: " + response.message());
                }

                userCards = response.body();
                Log.i("CardAPI", userCards.toString());
            }

            @Override
            public void onFailure(Call<List<CreditCard>> call, Throwable t) {
                Log.e("CardAPI", t.getMessage(), t);
            }
        });

        return userCards;
    }

    CreditCard getUserCardById(String creditCardNumber) {
        if(cardAPI == null) {
            start();
        }
        Call<CreditCard> call = cardAPI.getUserCardById(creditCardNumber);
        call.enqueue(new Callback<CreditCard>() {
            @Override
            public void onResponse(Call<CreditCard> call, Response<CreditCard> response) {
                if (!response.isSuccessful()) {
                    Log.e("CardAPI", "Code: " + response.message());
                }

                creditCard = response.body();
                Log.i("CardAPI", creditCard.toString());
            }

            @Override
            public void onFailure(Call<CreditCard> call, Throwable t) {
                Log.e("CardAPI", t.getMessage(), t);
            }
        });

        return creditCard;
    }

    CreditCard addNewUserCard(CreditCard creditCard) {
        if(cardAPI == null) {
            start();
        }
        Call<CreditCard> call = cardAPI.addNewUserCard(creditCard);
        call.enqueue(new Callback<CreditCard>() {
            @Override
            public void onResponse(Call<CreditCard> call, Response<CreditCard> response) {
                if (!response.isSuccessful()) {
                    Log.e("CardAPI", "Code: " + response.message());
                }

                creditCardResponse = response.body();
                Log.i("CardAPI", creditCardResponse.toString());
            }

            @Override
            public void onFailure(Call<CreditCard> call, Throwable t) {
                Log.e("CardAPI", t.getMessage(), t);
            }
        });

        return creditCardResponse;
    }
}
