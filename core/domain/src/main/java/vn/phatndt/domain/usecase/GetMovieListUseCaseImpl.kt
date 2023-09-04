package vn.phatndt.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import vn.phatndt.domain.repository.MovieRepository
import vn.phatndt.model.entity.Movie
import vn.phatndt.model.model.MovieModel

class GetMovieListUseCaseImpl(private val movieRepository: MovieRepository) : GetMovieListUseCase {
    override fun invoke(): Flow<PagingData<Movie>> {
        return movieRepository.getMovieList().map { pagingData ->
            pagingData.map {
                Movie(
                    it.adult,
                    it.backdrop_path,
                    it.genre_ids,
                    it.id,
                    it.original_language,
                    it.original_title,
                    it.overview,
                    it.popularity,
                    it.poster_path,
                    it.release_date,
                    it.title,
                    it.video,
                    it.vote_average,
                    it.vote_count
                )
            }
        }
    }
}