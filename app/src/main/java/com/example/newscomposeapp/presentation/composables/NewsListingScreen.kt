package com.example.newscomposeapp.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.newscomposeapp.R
import com.example.newscomposeapp.data.model.Article
import com.example.newscomposeapp.presentation.viewmodel.NewsListingViewModel

@Composable
fun NewsListScreen(viewModel: NewsListingViewModel, onClick: (Article) -> Unit) {
    val articles by viewModel.newsListLiveData.observeAsState(initial = listOf())
    val isLoading by viewModel.isLoading.observeAsState(initial = false)
    val error by viewModel.error.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
        } else if (error != null) {
            Text(
                text = error!!,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                color = Color.Red,
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp),
            ) {
                items(articles) { article ->
                    Article(article, onClick = onClick)
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        viewModel.fetchNews()
    }
}

@Composable
fun Article(article: Article, onClick: (Article) -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick(article) }
            .shadow(4.dp)
            .wrapContentHeight()
            .padding(16.dp),
    ) {
        Spacer(modifier = Modifier.padding(top = 8.dp))
        ArticleImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            articleImageUrl = article.urlToImage ?: "",
        )

        Text(
            text = article.title ?: "<NULL>",
            maxLines = 3,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = article.description ?: "<NULL>",
            maxLines = 4,
            color = Color.Gray,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = article.getFormattedPublishedAt(),
            color = Color.Gray,
        )
    }
}

@Composable
fun ArticleImage(modifier: Modifier, articleImageUrl: String) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(articleImageUrl)
            .placeholder(R.drawable.ic_image_downloading)
            .error(R.drawable.ic_image_not_found)
            .build(),
    )

    Image(
        painter = painter,
        contentDescription = "Article banner image",
        modifier = modifier,
        contentScale = ContentScale.Crop,
    )
}
