package com.zalesskyi.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(val id: Int,
                 val title: String): Parcelable