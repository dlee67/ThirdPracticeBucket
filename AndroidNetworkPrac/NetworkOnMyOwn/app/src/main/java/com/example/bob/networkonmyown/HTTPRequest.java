package com.example.bob.networkonmyown;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HTTPRequest {
    @GET("/users/dlee67/following")
    Call<List<ListOfFollowing>> getListOfFollowings();
}
