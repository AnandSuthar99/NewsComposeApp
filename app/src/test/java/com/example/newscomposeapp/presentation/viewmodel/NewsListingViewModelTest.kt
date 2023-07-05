package com.example.newscomposeapp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.newscomposeapp.data.articles
import com.example.newscomposeapp.domain.usecase.FetchNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsListingViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var useCase: FetchNewsUseCase
    private lateinit var viewModel: NewsListingViewModel
    private lateinit var scope: TestScope

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        val dispatcher = StandardTestDispatcher()
        scope = TestScope(dispatcher)
        Dispatchers.setMain(dispatcher)

        viewModel = NewsListingViewModel(useCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun fetchNews() = scope.runTest {
        // Given
        Mockito.`when`(useCase.execute()).thenReturn(articles)

        // When
        viewModel.fetchNews()
        advanceUntilIdle()

        // Then
        val result = viewModel.newsListLiveData.getOrAwaitValue()
        assertEquals(result, articles)
    }

    @Test
    fun `test fetchNews() useCase throws exception`() = scope.runTest {
        // Given
        val mockErrorMessage = "Error fetching items"
        Mockito.`when`(useCase.execute()).thenThrow(RuntimeException(mockErrorMessage))

        // When
        viewModel.fetchNews()
        advanceUntilIdle()

        // Then
        val result = viewModel.error.getOrAwaitValue()
        assertEquals(result, mockErrorMessage)
    }

    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS,
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }

        this.observeForever(observer)

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }
}
