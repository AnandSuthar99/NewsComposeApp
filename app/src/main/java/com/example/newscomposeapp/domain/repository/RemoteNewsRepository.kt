package com.example.newscomposeapp.domain.repository

import com.example.newscomposeapp.data.model.Article

interface RemoteNewsRepository {
    suspend fun fetchRemoteNews(): List<Article>
}
