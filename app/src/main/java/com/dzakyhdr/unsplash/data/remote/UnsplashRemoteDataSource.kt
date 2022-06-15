package com.dzakyhdr.unsplash.data.remote

import com.dzakyhdr.unsplash.data.remote.model.UnsplashResponseItem

class UnsplashRemoteDataSource(private val service: ApiService, private val apiKey: String) {

    suspend fun getPhotos(): List<UnsplashResponseItem> {
        try {
            return service.getPhotos(apiKey)
        } catch (cause: Throwable) {
            throw  Error("Terjadi Kesalahan", cause)
        }
    }

    suspend fun getDetailPhoto(id: String): UnsplashResponseItem{
        try {
            return service.getDetailPhotos(apiKey, id).body()!!
        } catch (cause: Throwable){
            throw Error("Terjadi Kesalahan", cause)
        }
    }
}

class Error(message: String, cause: Throwable?) : Throwable(message, cause)