package com.zalesskyi.data.network.models

import com.google.gson.annotations.SerializedName

data class AlbumResponse(@SerializedName("id")
                         val id: Int,
                         @SerializedName("title")
                         val title: String)