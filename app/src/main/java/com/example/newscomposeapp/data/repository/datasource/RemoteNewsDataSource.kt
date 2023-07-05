package com.example.newscomposeapp.data.repository.datasource

import com.example.newscomposeapp.data.model.Article

interface RemoteNewsDataSource {
    suspend fun fetchRemoteNews(): List<Article>
}
