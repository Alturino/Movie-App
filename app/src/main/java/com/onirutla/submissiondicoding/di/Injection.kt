package com.onirutla.submissiondicoding.di

import com.onirutla.submissiondicoding.data.model.remote.RemoteDataSource
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository
import com.onirutla.submissiondicoding.ui.detail.DetailViewModel
import com.onirutla.submissiondicoding.ui.home.movie.MovieViewModel
import com.onirutla.submissiondicoding.ui.home.tv.TvViewModel
import com.onirutla.submissiondicoding.utils.JsonHelper
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val jsonHelperModule = module {
    factory { JsonHelper(get()) }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single { MovieRepository(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}