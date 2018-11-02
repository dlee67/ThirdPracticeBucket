package com.example.bob.networkonmyown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
        Call<HTTPResponse> call = client.getString();

        call.enqueue(new Callback<HTTPResponse>() {
            @Override
            public void onResponse(Call<HTTPResponse> call, Response<HTTPResponse> response) {
                Log.i("dhl", response.body().getLogin());
            }

            @Override
            public void onFailure(Call<HTTPResponse> call, Throwable t) {
                Log.i("dhl", "Call failed: " + t.toString());
            }
        });
    }
}
