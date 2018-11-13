package com.example.bob.networkonmyown;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HTTPRequest {
    @GET("/users/dlee67/following")
    Call<List<FollowingUser>> getListOfFollowings();

    @GET("/users/{user}")
    Call<FollowingUser> seeIfHireable(@Path("user") String user);
}
