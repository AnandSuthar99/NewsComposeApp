package com.example.newscomposeapp.data.model

import org.junit.Assert
import org.junit.Test
import java.util.Calendar

class ApiResponseTest {

    @Test
    fun `test getFormattedPublishedAt for expected date`() {
        // Given
        val expectedResult = "05:04 pm - July 05, 2023"
        val calendar = Calendar.getInstance()
        calendar.set(2023, 6, 5, 17, 4, 30)
        val article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = calendar.time,
            source = Source("", ""),
            title = "",
            url = "",
            urlToImage = "",
        )

        // When
        val actualResult = article.getFormattedPublishedAt()

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `test getFormattedPublishedAt for null date`() {
        // Given
        val article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = null,
            source = Source("", ""),
            title = "",
            url = "",
            urlToImage = "",
        )

        // When
        val actualResult = article.getFormattedPublishedAt()

        // Then
        Assert.assertTrue(actualResult.isEmpty())
    }
}
