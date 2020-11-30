package com.onirutla.submissiondicoding.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onirutla.submissiondicoding.data.model.local.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}