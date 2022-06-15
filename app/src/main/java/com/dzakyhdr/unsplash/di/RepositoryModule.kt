package com.dzakyhdr.unsplash.di

import com.dzakyhdr.unsplash.data.remote.UnsplashRemoteDataSource
import com.dzakyhdr.unsplash.data.remote.UnsplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    @ViewModelScoped
    fun providePhotosRepository(
        remoteDataSource: UnsplashRemoteDataSource
    ): UnsplashRepository {
        return UnsplashRepository(remoteDataSource)
    }
}