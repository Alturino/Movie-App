package com.onirutla.submissiondicoding.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var title: String? = null,
    @DrawableRes var image: Int? = null,
    var description: String? = null
): Parcelable


