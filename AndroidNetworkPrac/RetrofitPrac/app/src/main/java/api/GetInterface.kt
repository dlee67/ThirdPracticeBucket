package api

import retrofit2.Call
import retrofit2.http.GET

interface GetInterface {

    // The below line spcifies a GET request to /someURL
    @GET("/someURL")
    // The Call is an objected containing a HTTP request and response pair.
    fun retrieveRepositories(): Call<Unit>
}