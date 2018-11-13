package com.example.bob.networkonmyown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HTTPRequest client = retrofit.create(HTTPRequest.class);

        Call<List<FollowingUser>> followings = client.getListOfFollowings();

        // The below block of code won't because HTTP requests must be made
        // in a Thread other than UIThread.
        //List<FollowingUser> listOfFollowings = null;
        //try {
        //    listOfFollowings = followings.execute().body();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //Call<FollowingUser> user = null;
        //for(int index = 0; index < listOfFollowings.size(); index++){
        //    try {
        //        FollowingUser followingUser = client.seeIfHireable(listOfFollowings.get(index).getLogin())
        //                .execute().body();
        //        if(client.seeIfHireable(listOfFollowings.get(index).getLogin())
        //                .execute().body().getHireable()){
        //            Log.i("dhl", "User: " + followingUser.getLogin()
        //            + "is hireable.");
        //        }
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }
        //}

        // The below is a way to execute things asynchronously.
        // It's even needed because you can't make HTTP request on a main thread in Android
        followings.enqueue(new Callback<List<FollowingUser>>() {
            @Override
            public void onResponse(Call<List<FollowingUser>> call, Response<List<FollowingUser>> response) {
                List<FollowingUser> followings = response.body();
                //Log.i("dhl", followings.toString());
                for(int index = 0; index < (followings.size() - 1); index++){
                    Log.i("dhl", followings.get(index).getLogin());
                }
            }
        
            @Override
            public void onFailure(Call<List<FollowingUser>> call, Throwable t) {
                Log.i("dhl", "Call failed: " + t.toString());
            }
        });
    }
}
