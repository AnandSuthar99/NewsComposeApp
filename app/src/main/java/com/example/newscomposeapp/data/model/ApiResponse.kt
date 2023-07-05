package com.example.newscomposeapp.data.model

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

data class APIResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int,
)

data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: Date?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
) : Serializable {

    fun getFormattedPublishedAt(): String {
        val toFormat = SimpleDateFormat("hh:mm a - MMM dd, yyyy", Locale.getDefault())
        toFormat.timeZone = TimeZone.getDefault()
        this.publishedAt?.let {
            return toFormat.format(it)
        }
        return this.publishedAt?.toString() ?: ""
    }
}

data class Source(
    val id: String?,
    val name: String?,
) : Serializable
