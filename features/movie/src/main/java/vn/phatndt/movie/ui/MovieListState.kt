package vn.phatndt.movie.ui

import androidx.paging.PagingData
import vn.phatndt.model.entity.Movie

sealed interface MovieListState {
    object Loading : MovieListState
    data class Success(val movieList: PagingData<Movie>) : MovieListState
    data class Error(val throwable: Throwable) : MovieListState
}