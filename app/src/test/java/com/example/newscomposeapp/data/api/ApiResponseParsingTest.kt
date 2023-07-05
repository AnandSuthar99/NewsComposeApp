@file:OptIn(ExperimentalCoroutinesApi::class)

package com.example.newscomposeapp.data.api

import android.annotation.SuppressLint
import com.example.newscomposeapp.data.repository.datasource.RemoteNewsDataSource
import com.example.newscomposeapp.data.repository.datasource.RemoteNewsDataSourceImpl
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiResponseParsingTest {
    private lateinit var server: MockWebServer
    private lateinit var apiService: NewsApiService
    private lateinit var dataSource: RemoteNewsDataSource
    private lateinit var scope: TestScope

    @Before
    fun setUp() {
        server = MockWebServer()
        apiService = Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(NewsApiService::class.java)

        val dispatcher = StandardTestDispatcher()
        scope = TestScope(dispatcher)
        dataSource = RemoteNewsDataSourceImpl(
            apiService,
            dispatcher,
        )

        Dispatchers.setMain(dispatcher)
    }

    private fun enqueueMockResponse(fileName: String) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            server.enqueue(mockResponse)
        }
    }

    @SuppressLint("CheckResult")
    @Test
    fun `test expected list of articles`() = scope.runTest {
        // Given
        enqueueMockResponse("api-response/response.json")

        // When
        val response = dataSource.fetchRemoteNews()

        // Then
        Assert.assertTrue(response.isNotEmpty())
        Assert.assertTrue(response.size == 20)
    }

    @Test
    fun `test empty list of articles`() = scope.runTest {
        // Given
        enqueueMockResponse("api-response/empty-response.json")

        // When
        val response = dataSource.fetchRemoteNews()

        // Then
        Assert.assertTrue(response.isEmpty())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        server.shutdown()
    }
}
