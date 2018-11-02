package com.example.bob.retrofitprac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import api.GitHubClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView: ListView = findViewById(R.id.pagination_list);

        var builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                // Because Github uses JSON as the data format.
                .addConverterFactory(GsonConverterFactory.create())

        var retrofit: Retrofit = builder.build()
        var client: GitHubClient = retrofit.create(GitHubClient::class.java)
        var call = client.reposForUser("fs-opensource");

        var enqueueObject = object: Callback<List<GitHubRepo>> {
            override fun onFailure(call: Call<List<GitHubRepo>>?, t: Throwable?) {
                Log.v("retrofit", "call failed")
            }

            override fun onResponse(call: Call<List<GitHubRepo>>?, response: Response<List<GitHubRepo>>?) {
            }

        }

        call.enqueue(enqueueObject)
    }
}
