package com.adncoding.composemovielistretrofitmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.adncoding.composemovielistretrofitmvvm.ui.screen.MainScreen
import com.adncoding.composemovielistretrofitmvvm.ui.theme.ComposeMovieListRetrofitMVVMTheme
import com.adncoding.composemovielistretrofitmvvm.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {
    private val movieViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMovieListRetrofitMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(movieViewModel.movieList)
                    movieViewModel.processGetMovieList()
                }
            }
        }
    }
}