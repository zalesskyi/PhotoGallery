package com.zalesskyi.data.network.models

import com.google.gson.annotations.SerializedName

data class PhotoResponse(@SerializedName("albumId")
                         val albumId: Int,
                         @SerializedName("id")
                         val id: Int,
                         @SerializedName("title")
                         val title: String,
                         @SerializedName("url")
                         val url: String,
                         @SerializedName("thumbnailUrl")
                         val thumbUrl: String)