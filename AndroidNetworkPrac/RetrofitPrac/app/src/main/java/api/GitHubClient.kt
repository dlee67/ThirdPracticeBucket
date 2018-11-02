package api

import com.example.bob.retrofitprac.GitHubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.List

public interface GitHubClient {

    // The below line spcifies a GET request to /someURL
    @GET("/users/{users}/repos")
    // Call objects contains the req and res of the
    fun reposForUser(@Path("user") user: String): Call<List<GitHubRepo>>
}