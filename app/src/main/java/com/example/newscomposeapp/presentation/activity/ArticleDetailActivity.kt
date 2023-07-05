package com.example.newscomposeapp.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.newscomposeapp.data.model.Article
import com.example.newscomposeapp.presentation.activity.ui.theme.NewsComposeAppTheme
import com.example.newscomposeapp.presentation.composables.ArticleDetailScreen

class ArticleDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val article: Article = intent.getSerializableExtra("article") as Article
        setContent {
            NewsComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ArticleDetailScreen(article = article)
                }
            }
        }
    }
}
