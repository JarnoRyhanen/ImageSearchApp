package com.home.imagesearchapp.api

import com.home.imagesearchapp.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    companion object {
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
        const val BASE_URL = "https://api.unsplash.com/"
    }

    @Headers("Accept-Version: v1", "Authorization: Client_ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: String,
        @Query("per_page") perPage: String
    ): UnsplashResponse

    
}