package com.onirutla.submissiondicoding.data.model.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.onirutla.submissiondicoding.data.model.local.MovieEntity
import com.onirutla.submissiondicoding.data.model.remote.ApiResponse
import com.onirutla.submissiondicoding.data.model.remote.MovieResponse
import com.onirutla.submissiondicoding.data.model.remote.RemoteDataSource
import com.onirutla.submissiondicoding.data.source.LocalDataSource
import com.onirutla.submissiondicoding.data.source.MovieDataSource
import com.onirutla.submissiondicoding.data.source.NetworkBoundResource
import com.onirutla.submissiondicoding.utils.AppExecutors
import com.onirutla.submissiondicoding.utils.vo.Resource

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieDataSource {
    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> =
        object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                data.forEach {
                    val movie = MovieEntity(
                        it.id,
                        it.type,
                        it.title,
                        it.year,
                        it.genre,
                        it.rating,
                        it.description,
                        it.poster,
                        it.trailer
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()


    override fun getAllTv(): LiveData<Resource<PagedList<MovieEntity>>> =
        object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllTvShows()


            override fun saveCallResult(data: List<MovieResponse>) {
                val tvShowList = ArrayList<MovieEntity>()
                data.forEach {
                    val tvShow = MovieEntity(
                        it.id,
                        it.type,
                        it.title,
                        it.year,
                        it.genre,
                        it.rating,
                        it.description,
                        it.poster,
                        it.trailer,
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertMovies(tvShowList)
            }
        }.asLiveData()

    override fun getDetailMovie(id: String): LiveData<Resource<MovieEntity>> =
        object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDb(): LiveData<MovieEntity> =
                localDataSource.getMovieDetail(id)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                data.forEach {
                    val movie = MovieEntity(
                        it.id,
                        it.type,
                        it.title,
                        it.year,
                        it.genre,
                        it.rating,
                        it.description,
                        it.poster,
                        it.trailer
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()


    override fun getDetailTv(id: String): LiveData<Resource<MovieEntity>> =
        object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDb(): LiveData<MovieEntity> =
                localDataSource.getTvDetail(id)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<MovieResponse>) {
                val tvShowList = ArrayList<MovieEntity>()
                data.forEach {
                    val tvShow = MovieEntity(
                        it.id,
                        it.type,
                        it.title,
                        it.year,
                        it.genre,
                        it.rating,
                        it.description,
                        it.poster,
                        it.trailer
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertMovies(tvShowList)
            }
        }.asLiveData()

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTv(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavorite(movie, state) }
}