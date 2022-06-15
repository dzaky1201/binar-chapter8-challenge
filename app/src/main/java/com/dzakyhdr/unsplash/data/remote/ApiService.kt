package com.dzakyhdr.unsplash.data.remote


import com.dzakyhdr.unsplash.data.remote.model.UnsplashResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") clientId: String
    ): List<UnsplashResponseItem>

    @GET("photos/{id}")
    suspend fun getDetailPhotos(
        @Query("client_id") clientId: String,
        @Path("id") id: String
    ): Response<UnsplashResponseItem>
}