package com.example.bob.networkonmyown;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestIfHireable {

    public static void seeIfHireable(String userName) {
        String baseUrl = "https://api.github.com/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
