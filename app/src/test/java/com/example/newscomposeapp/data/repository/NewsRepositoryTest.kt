package com.example.newscomposeapp.data.repository

import android.annotation.SuppressLint
import com.example.newscomposeapp.data.articles
import com.example.newscomposeapp.data.repository.datasource.RemoteNewsDataSource
import com.example.newscomposeapp.domain.repository.RemoteNewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class NewsRepositoryTest {

    @Mock
    lateinit var dataSource: RemoteNewsDataSource
    lateinit var repository: RemoteNewsRepository
    private lateinit var scope: TestScope

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        val dispatcher = StandardTestDispatcher()
        scope = TestScope(dispatcher)
        repository = RemoteNewsRepositoryImpl(dataSource)

        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @SuppressLint("CheckResult")
    @Test
    fun `test fetchRemoteNews with expected articles list response`() = scope.runTest {
        // Given
        Mockito.`when`(dataSource.fetchRemoteNews()).thenReturn(articles)

        // When
        val actualResponse = repository.fetchRemoteNews()

        // Then
        Assert.assertEquals(actualResponse.size, articles.size)
    }

    @Test
    fun `test fetchRemoteNews with empty list of articles in response`() = scope.runTest {
        // Given
        Mockito.`when`(dataSource.fetchRemoteNews()).thenReturn(emptyList())

        // When
        val actualResponse = repository.fetchRemoteNews()

        // Then
        Assert.assertTrue(actualResponse.isEmpty())
    }

    @Test
    fun `test fetchRemoteNews with error response`() = scope.runTest {
        // Given
        Mockito.`when`(dataSource.fetchRemoteNews()).thenReturn(emptyList())

        // When
        val actualResponse = repository.fetchRemoteNews()

        // Then
        Assert.assertTrue(actualResponse.isEmpty())
    }
}
