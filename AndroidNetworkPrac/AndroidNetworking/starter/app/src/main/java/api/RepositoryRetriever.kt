package api

import com.raywenderlich.githubrepolist.data.RepoResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRetriever {
    private val service: GithubService

    companion object {
        const val BASE_URL = "https://api.github.com/"  //1
    }

    init {
        // 2
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL) //1
                .addConverterFactory(GsonConverterFactory.create()) //3
                .build()
        service = retrofit.create(GithubService::class.java) //4
    }

    fun getRepositories(callback: Callback<RepoResult>) { //5
        val call = service.searchRepositories()
        call.enqueue(callback)
    }
}