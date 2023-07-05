package com.example.newscomposeapp.data.di

import com.example.newscomposeapp.data.repository.RemoteNewsRepositoryImpl
import com.example.newscomposeapp.data.repository.datasource.RemoteNewsDataSource
import com.example.newscomposeapp.domain.repository.RemoteNewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun providesRemoteNewsRepository(remoteNewsDataSource: RemoteNewsDataSource): RemoteNewsRepository =
        RemoteNewsRepositoryImpl(remoteNewsDataSource)
}
