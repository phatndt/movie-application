package vn.phatndt.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import vn.phatndt.model.entity.Movie
import vn.phatndt.model.model.MovieModel

interface GetMovieListUseCase {
    operator fun invoke(): Flow<PagingData<Movie>>
}