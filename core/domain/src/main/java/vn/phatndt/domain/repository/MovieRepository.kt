package vn.phatndt.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import vn.phatndt.model.model.MovieModel

interface MovieRepository {
    fun getMovieList(): Flow<PagingData<MovieModel>>
}
