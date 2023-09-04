package vn.phatndt.data.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module
import vn.phatndt.data.datasource.MoviePagingSource
import vn.phatndt.data.datasource.remote.MovieService
import vn.phatndt.data.repository.MovieRepositoryImpl
import vn.phatndt.domain.repository.MovieRepository

val dataModule = module {
    single {
        HttpClient() {
            install(ContentNegotiation) {
                json()
            }
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(
                            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0NTllMzhmMDMwNGNmOTE0NjJkYTExODcyNjU4MTcxMSIsInN1YiI6IjYyMWM0MWVmMWY5OGQxMDA2YmRiNDEwYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dgIbZCugCetk4A35TU3jkle_pHTKZjfwv4hPt8c_RUM",
                            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0NTllMzhmMDMwNGNmOTE0NjJkYTExODcyNjU4MTcxMSIsInN1YiI6IjYyMWM0MWVmMWY5OGQxMDA2YmRiNDEwYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dgIbZCugCetk4A35TU3jkle_pHTKZjfwv4hPt8c_RUM",
                        )
                    }
                }
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
    single { MovieService(get()) }
    single { MoviePagingSource(get()) }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}