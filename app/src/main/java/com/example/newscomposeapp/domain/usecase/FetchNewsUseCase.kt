package com.example.newscomposeapp.domain.usecase

import com.example.newscomposeapp.data.model.Article
import com.example.newscomposeapp.domain.repository.RemoteNewsRepository
import javax.inject.Inject

class FetchNewsUseCase @Inject constructor(private val remoteNewsRepository: RemoteNewsRepository) {
    suspend fun execute(): List<Article> = remoteNewsRepository.fetchRemoteNews()
}
