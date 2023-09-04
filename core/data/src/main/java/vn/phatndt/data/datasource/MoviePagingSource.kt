package vn.phatndt.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import vn.phatndt.data.datasource.remote.MovieService
import vn.phatndt.model.model.MovieModel

class MoviePagingSource(
    private val movieService: MovieService,
) : PagingSource<Int, MovieModel>() {

    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = withContext(Dispatchers.IO) {
                movieService.getMovieList(nextPageNumber)
            }
            LoadResult.Page(
                data = response.movieList,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(Exception(""))
        }
    }


}