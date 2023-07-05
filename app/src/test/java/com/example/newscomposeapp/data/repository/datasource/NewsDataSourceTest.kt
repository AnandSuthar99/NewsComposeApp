package com.example.newscomposeapp.data.repository.datasource

import com.example.newscomposeapp.data.api.NewsApiService
import com.example.newscomposeapp.data.articles
import com.example.newscomposeapp.data.model.APIResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class NewsDataSourceTest {

    @Mock
    private lateinit var apiService: NewsApiService
    private lateinit var dataSource: RemoteNewsDataSource
    private lateinit var scope: TestScope

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        val dispatcher = StandardTestDispatcher()
        scope = TestScope(dispatcher)
        dataSource = RemoteNewsDataSourceImpl(
            apiService,
            dispatcher,
        )

        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `Test getTopHeadlines with expected articles response`() = scope.runTest {
        // Given
        val apiResponse =
            Response.success(APIResponse(articles = articles, status = "Ok", totalResults = 20))

        Mockito.`when`(apiService.getTopHeadlines()).thenReturn(apiResponse)

        // When
        val actualResponse = dataSource.fetchRemoteNews()

        // Then
        Assert.assertEquals(actualResponse, articles)
    }

    @Test
    fun `Test getTopHeadlines with empty list response`() = runTest {
        // Given
        val expectedResponse =
            Response.success(APIResponse(articles = listOf(), status = "Ok", totalResults = 0))
        Mockito.`when`(apiService.getTopHeadlines()).thenReturn(expectedResponse)

        // When
        val actualResponse = dataSource.fetchRemoteNews()

        // Then
        Assert.assertEquals(actualResponse.size, expectedResponse.body()?.articles?.size)
    }

    @Test
    fun `Test getTopHeadlines with error response`() = runTest {
        // Given
        val expectedResponse = Response.error<APIResponse>(400, "".toResponseBody())
        Mockito.`when`(apiService.getTopHeadlines()).thenReturn(expectedResponse)

        // When
        val actualResponse = dataSource.fetchRemoteNews()

        // Then
        Assert.assertTrue(actualResponse.isEmpty())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
