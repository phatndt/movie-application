package vn.phatndt.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import vn.phatndt.data.datasource.MoviePagingSource
import vn.phatndt.domain.repository.MovieRepository
import vn.phatndt.model.model.MovieModel

class MovieRepositoryImpl(private val moviePagingSource: MoviePagingSource) : MovieRepository {
    override fun getMovieList(): Flow<PagingData<MovieModel>> {
        return Pager(
            PagingConfig(pageSize = 20, initialLoadSize = 20),
            initialKey = 1,
            pagingSourceFactory = { moviePagingSource }).flow
    }
}