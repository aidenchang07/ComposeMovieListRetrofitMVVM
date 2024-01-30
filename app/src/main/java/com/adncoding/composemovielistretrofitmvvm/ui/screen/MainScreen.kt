package com.adncoding.composemovielistretrofitmvvm.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.adncoding.composemovielistretrofitmvvm.model.Movie

/**
 * Created by AidenChang 2024/01/28
 */

@Composable
fun MainScreen(movieList: List<Movie>) {
    LazyColumn {
        items(items = movieList) {
            MovieItem(it)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 4.dp)
            .height(110.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(4.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = movie.imageUrl,
                    builder = {
                        scale(Scale.FIT)
                        placeholder(R.drawable.notification_action_background)
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = movie.desc,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(4.dp)
                    .weight(0.8f)
            ) {
                Text(
                    text = movie.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily.Default
                )
                Text(
                    text = movie.category,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.background(Color.LightGray).padding(4.dp)
                )
                Text(
                    text = movie.desc,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    val movie = Movie(
        "Developer's Says",
        "",
        "Hi Guys!! Please Like And Subscribe to My channel",
        "Hello"
    )
    MovieItem(movie = movie)
}