package vn.phatndt.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import vn.phatndt.model.model.MovieModel

@Serializable
data class GetMovieResponse(
    @SerialName("page") val page: Int,
    @SerialName("total_pages") val totalPages: Int? = null,
    @SerialName("total_results") val totalResults: Int? = null,
    @SerialName("results") val movieList: List<MovieModel>,
)
