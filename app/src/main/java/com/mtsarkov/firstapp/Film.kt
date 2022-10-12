package com.mtsarkov.firstapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val title: String,
    val poster: Int,
    val description: String,
    var rating: Float,
    var isInFavorites: Boolean = false
) : Parcelable