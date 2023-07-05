package com.example.newscomposeapp.data.repository

import com.example.newscomposeapp.data.model.Article
import com.example.newscomposeapp.data.repository.datasource.RemoteNewsDataSource
import com.example.newscomposeapp.domain.repository.RemoteNewsRepository
import javax.inject.Inject

class RemoteNewsRepositoryImpl @Inject constructor(private val remoteNewsDataSource: RemoteNewsDataSource) :
    RemoteNewsRepository {
    override suspend fun fetchRemoteNews(): List<Article> {
        return remoteNewsDataSource.fetchRemoteNews()
    }
}
