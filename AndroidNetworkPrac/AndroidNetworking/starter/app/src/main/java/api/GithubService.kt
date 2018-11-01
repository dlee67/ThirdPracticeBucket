package api

import com.raywenderlich.githubrepolist.data.RepoResult
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    //The below two lines makes a GET request to some Github place.

    @GET("/repositories")
    fun retrieveRepositories(): Call<RepoResult>

    @GET("/search/repositories?q=language:kotlin&sort=stars&order=desc")
    fun searchRepositories(): Call<RepoResult>
}