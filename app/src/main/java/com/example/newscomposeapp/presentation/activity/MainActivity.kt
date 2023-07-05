package com.example.newscomposeapp.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.newscomposeapp.data.model.Article
import com.example.newscomposeapp.presentation.composables.NewsListScreen
import com.example.newscomposeapp.presentation.viewmodel.NewsListingViewModel
import com.example.newscomposeapp.ui.theme.NewsComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: NewsListingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    NewsListScreen(viewModel, onClick = {
                        startArticleDetailActivity(it)
                    })
                }
            }
        }
    }

    private fun startArticleDetailActivity(it: Article) {
        val intent = Intent(this, ArticleDetailActivity::class.java)
        intent.putExtra("article", it)
        this.startActivity(intent)
    }
}
