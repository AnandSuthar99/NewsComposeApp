package com.example.newscomposeapp.data.di

import com.example.newscomposeapp.data.api.NewsApiService
import com.example.newscomposeapp.data.repository.datasource.RemoteNewsDataSource
import com.example.newscomposeapp.data.repository.datasource.RemoteNewsDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(ViewModelComponent::class)
@Module
class DataSourceModule {

    @Provides
    fun providesRemoteNewsDataSource(
        newsApiService: NewsApiService,
        dispatcher: CoroutineDispatcher,
    ): RemoteNewsDataSource = RemoteNewsDataSourceImpl(newsApiService, dispatcher)
}
