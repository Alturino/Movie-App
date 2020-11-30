package com.onirutla.submissiondicoding.data.model.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.NotNull

@Entity(tableName = "movie_entities")
@Parcelize
data class MovieEntity(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "year")
    val year: String,
    @ColumnInfo(name = "genre")
    val genre: String,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "poster")
    val poster: String,
    @ColumnInfo(name = "trailer")
    val trailer: String,
    @ColumnInfo(name = "is_favorite")
    var is_favorite: Boolean = false
) : Parcelable


