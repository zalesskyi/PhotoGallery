package com.zalesskyi.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(val albumId: Int,
                 val id: Int,
                 val title: String,
                 val url: String,
                 val thumbUrl: String): Parcelable