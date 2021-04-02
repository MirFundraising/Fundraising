package com.example.mirand.controllers;

import com.example.mirand.util.Cluster;
import com.example.mirand.util.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClusterAPI {

    @GET("cluster")
    Call<List<Cluster>> getUserClusterList(@Query("user") User user);

    @GET("cluster/{clusterName}/")
    Call<Cluster> getUserClusterByClusterName
            (@Path("clusterName") String clusterName, @Query("user") User user);

    @POST("cluster")
    Call<Cluster> createNewUserCluster(@Body User user, @Body Cluster cluster);


    @PUT("cluster/{name}")
    Call<User> addNewMemberToCluster(@Path("name") String name,
                                     @Body User user,
                                     @Body Cluster cluster);
}
