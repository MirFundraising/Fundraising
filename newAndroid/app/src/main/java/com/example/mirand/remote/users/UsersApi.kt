package com.example.mirand.remote.users

import retrofit2.http.GET

interface UsersApi {
    @GET(./)
    fun getCurrentUser()
}