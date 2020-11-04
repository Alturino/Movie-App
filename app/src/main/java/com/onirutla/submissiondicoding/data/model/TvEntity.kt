package com.onirutla.submissiondicoding.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvEntity(
    var id: String? = null,
    var title: String? = null,
    @DrawableRes var image : Int? = null,
    var description: String? = null
): Parcelable