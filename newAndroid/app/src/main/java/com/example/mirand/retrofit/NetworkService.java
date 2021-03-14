package com.example.mirand.retrofit;
import retrofit2.Retrofit;
public class NetworkConnection {
    private static NetworkService mInstance;

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }
}
