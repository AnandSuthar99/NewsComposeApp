package com.example.newscomposeapp.domain.usecase

import com.example.newscomposeapp.data.articles
import com.example.newscomposeapp.data.repository.RemoteNewsRepositoryImpl
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

class FetchNewsUseCaseTest {

    @Mock
    lateinit var repository: RemoteNewsRepositoryImpl
    private lateinit var scope: TestScope
    lateinit var useCase: FetchNewsUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        val dispatcher = StandardTestDispatcher()
        scope = TestScope(dispatcher)
        Dispatchers.setMain(dispatcher)

        useCase = FetchNewsUseCase(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test execute with expected list`() = scope.runTest {
        // Given
        Mockito.`when`(repository.fetchRemoteNews()).thenReturn(articles)

        // When
        val remoteNewsArticles = useCase.execute()

        // Then
        Assert.assertTrue(remoteNewsArticles.isNotEmpty())
        Assert.assertEquals(remoteNewsArticles.size, articles.size)
    }

    @Test
    fun `test execute with empty results`() = scope.runTest {
        // Given
        Mockito.`when`(repository.fetchRemoteNews())
            .thenReturn(emptyList())

        // When
        val articleList = useCase.execute()

        // Then
        Assert.assertTrue(articleList.isEmpty())
    }
}
