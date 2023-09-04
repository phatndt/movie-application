package vn.phatndt.movie.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.phatndt.movie.ui.MovieListViewModel

val movieModule = module {
    viewModel { MovieListViewModel(get()) }
}