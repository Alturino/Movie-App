package com.onirutla.submissiondicoding.di

import androidx.room.Room
import com.onirutla.submissiondicoding.data.model.remote.RemoteDataSource
import com.onirutla.submissiondicoding.data.model.repository.MovieRepository
import com.onirutla.submissiondicoding.data.source.LocalDataSource
import com.onirutla.submissiondicoding.db.MovieDatabase
import com.onirutla.submissiondicoding.ui.detail.DetailViewModel
import com.onirutla.submissiondicoding.ui.favorite.movie.FavoriteMovieViewModel
import com.onirutla.submissiondicoding.ui.favorite.tv.FavoriteTvViewModel
import com.onirutla.submissiondicoding.ui.home.movie.MovieViewModel
import com.onirutla.submissiondicoding.ui.home.tv.TvViewModel
import com.onirutla.submissiondicoding.utils.AppExecutors
import com.onirutla.submissiondicoding.utils.JsonHelper
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val jsonHelperModule = module {
    factory { JsonHelper(get()) }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single { MovieRepository(get(), get(), get()) }
}

val databaseModule = module {
    factory { get<MovieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java,
            "movie.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { FavoriteTvViewModel(get()) }
}