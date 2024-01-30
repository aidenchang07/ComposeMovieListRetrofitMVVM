package com.adncoding.composemovielistretrofitmvvm.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adncoding.composemovielistretrofitmvvm.model.Movie
import com.adncoding.composemovielistretrofitmvvm.network.ApiService
import kotlinx.coroutines.launch

/**
 * Created by AidenChang 2024/01/18
 */
class MovieViewModel: ViewModel() {
    var movieList: List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun processGetMovieList() {
        viewModelScope.launch {
            try {
                movieList = ApiService.getInstance().getMovies()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}