package com.zalesskyi.data.network.api

import com.zalesskyi.data.network.models.AlbumResponse
import com.zalesskyi.data.network.models.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MediaApi {

    @GET("albums")
    suspend fun getAlbums(): List<AlbumResponse>

    @GET("albums/{id}/photos")
    suspend fun getPhotos(@Path("id") albumId: Int): List<PhotoResponse>
}