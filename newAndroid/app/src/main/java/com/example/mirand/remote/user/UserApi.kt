package com.example.mirand.remote.user

import com.example.mirand.util.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @GET()
    fun getCurrentUser():Single<User>

    @POST()
    fun createNewUser()

    @
}