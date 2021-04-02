package com.example.mirand.controllers;

import com.example.mirand.util.Cluster;
import com.example.mirand.util.Fundraising;
import com.example.mirand.util.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FundraisingAPI {
    @GET("fundraising")
    Call<List<Fundraising>> getFundraisingListOfCluster(@Query("cluster") Cluster cluster);

    @GET("fundraising/{id}/")
    Call<Fundraising> getFundraisingById(@Path("id") String id,
                                         @Query("cluster") Cluster cluster);

    @POST("fundraising")
    Call<Fundraising> createNewFundraising(@Body Fundraising fundraising, @Body Cluster cluster);

    @PUT("fundraising/{id}")
    Call<Fundraising> changeFundraisingCurrentFunds(@Path("id") String id,
                                                    @Body Fundraising fundraising,
                                                    @Body Cluster cluster);
}
