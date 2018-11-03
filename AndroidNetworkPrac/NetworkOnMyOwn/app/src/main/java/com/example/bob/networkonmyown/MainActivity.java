package com.example.bob.networkonmyown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

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
        Call<List<ListOfFollowing>> call = client.getListOfFollowings();

        call.enqueue(new Callback<List<ListOfFollowing>>() {
            @Override
            public void onResponse(Call<List<ListOfFollowing>> call, Response<List<ListOfFollowing>> response) {
                List<ListOfFollowing> followings = response.body();
                //Log.i("dhl", followings.toString());
                for(int index = 0; index < (followings.size() - 1); index++){
                    Log.i("dhl", followings.get(index).getLogin());
                }
            }

            @Override
            public void onFailure(Call<List<ListOfFollowing>> call, Throwable t) {
                Log.i("dhl", "Call failed: " + t.toString());
            }
        });
    }
}
