package com.example.newscomposeapp.data.di

import com.example.newscomposeapp.domain.repository.RemoteNewsRepository
import com.example.newscomposeapp.domain.usecase.FetchNewsUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UsecaseModule {
    fun providesFetchNewsUseCase(newsRepository: RemoteNewsRepository) =
        FetchNewsUseCase(newsRepository)
}
