package com.example.bob.networkonmyown;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HTTPSeeIfHireable {
    @GET("/users/{user}")
    Call<User> seeIfHireable(@Path("user") String user);
}
