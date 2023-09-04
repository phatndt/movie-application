package vn.phatndt.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import vn.phatndt.model.model.MovieModel
import vn.phatndt.model.response.GetMovieResponse

interface MovieRepository {
    fun getMovieList(): Flow<PagingData<MovieModel>>
}