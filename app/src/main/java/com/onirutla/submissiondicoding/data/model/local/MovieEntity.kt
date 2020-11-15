package com.onirutla.submissiondicoding.data.model.local

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    val id: String,
    val type: String,
    val title: String,
    val year: String,
    val genre: String,
    val rating: Double,
    val description: String,
    val poster: String,
    val trailer: String
) : Parcelable


