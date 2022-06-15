package com.dzakyhdr.unsplash.data.remote

import com.dzakyhdr.unsplash.data.remote.model.UnsplashResponseItem

class UnsplashRepository(private val dataSource: UnsplashRemoteDataSource) {

    suspend fun getPhotos(): List<UnsplashResponseItem> {
        return dataSource.getPhotos()
    }

    suspend fun getDetailPhoto(id: String): UnsplashResponseItem{
        return dataSource.getDetailPhoto(id)
    }


}