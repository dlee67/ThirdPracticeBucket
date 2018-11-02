package com.example.bob.networkonmyown;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HTTPRequest {
    @GET("/users/dlee67")
    Call<HTTPResponse> getString();
}
