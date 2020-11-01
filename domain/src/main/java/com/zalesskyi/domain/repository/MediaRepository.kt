package com.zalesskyi.domain.repository

import com.zalesskyi.domain.models.Album
import com.zalesskyi.domain.models.Photo

interface MediaRepository {

    suspend fun getAlbums(): List<Album>

    suspend fun getPhotos(albumId: Int): List<Photo>
}