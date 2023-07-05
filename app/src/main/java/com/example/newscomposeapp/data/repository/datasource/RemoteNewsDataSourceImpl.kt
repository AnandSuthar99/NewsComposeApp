package com.example.newscomposeapp.data.repository.datasource

import com.example.newscomposeapp.data.api.NewsApiService
import com.example.newscomposeapp.data.model.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteNewsDataSourceImpl @Inject constructor(
    private val newsApiService: NewsApiService,
    private val dispatcher: CoroutineDispatcher,
) : RemoteNewsDataSource {

    override suspend fun fetchRemoteNews(): List<Article> {
        return withContext(dispatcher) {
            val response = newsApiService.getTopHeadlines()
            if (response.isSuccessful) {
                response.body()?.articles ?: listOf()
            } else {
                listOf()
            }
        }
    }
}
