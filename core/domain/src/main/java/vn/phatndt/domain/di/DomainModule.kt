package vn.phatndt.domain.di

import org.koin.dsl.module
import vn.phatndt.domain.usecase.GetMovieListUseCase
import vn.phatndt.domain.usecase.GetMovieListUseCaseImpl

val domainModule = module {
    single<GetMovieListUseCase> { GetMovieListUseCaseImpl(get()) }
}