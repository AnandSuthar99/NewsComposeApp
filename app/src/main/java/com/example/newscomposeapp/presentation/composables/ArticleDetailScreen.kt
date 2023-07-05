package com.example.newscomposeapp.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.newscomposeapp.R
import com.example.newscomposeapp.data.model.Article

@Composable
fun ArticleDetailScreen(article: Article) {
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
    ) {
        Text(
            text = article.title ?: "<NULL>",
            maxLines = 3,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            fontSize = 22.sp,
            modifier = Modifier.padding(8.dp),
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        ArticleBanner(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            imageUrl = article.urlToImage ?: "",
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        ArticleContent(article = article, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun ArticleBanner(modifier: Modifier, imageUrl: String) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl)
            .placeholder(R.drawable.ic_image_downloading).error(R.drawable.ic_image_not_found)
            .build(),
    )
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = "Article banner image",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
    )
}

@Composable
fun ArticleContent(modifier: Modifier, article: Article) {
    Column(modifier = modifier) {
        Text(
            text = article.description ?: "<NULL>",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        Text(
            text = article.content ?: "<NULL>",
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        Text(
            text = "Author: ${article.author ?: ""}",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        Text(
            text = article.getFormattedPublishedAt(),
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            textAlign = TextAlign.End,
        )
    }
}
