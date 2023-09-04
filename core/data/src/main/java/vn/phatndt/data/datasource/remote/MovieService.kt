package vn.phatndt.data.datasource.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import kotlinx.coroutines.delay
import vn.phatndt.model.response.GetMovieResponse

class MovieService(private val httpClient: HttpClient) {
    suspend fun getMovieList(page: Int): GetMovieResponse {
        val response = httpClient.request("https://api.themoviedb.org/3/movie/popular?language=en-US&page=$page") {
            method = HttpMethod.Get
        }
        delay(5000)
        return response.body()
    }
}