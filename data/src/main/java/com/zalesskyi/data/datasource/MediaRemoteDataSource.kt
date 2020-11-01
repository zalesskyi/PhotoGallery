package com.zalesskyi.data.datasource

import com.zalesskyi.data.mappers.toDomain
import com.zalesskyi.data.network.api.MediaApi
import com.zalesskyi.domain.models.Album
import com.zalesskyi.domain.models.Photo
import javax.inject.Inject

interface MediaRemoteDataSource {

    suspend fun getAlbums(): List<Album>

    suspend fun getPhotos(albumId: Int): List<Photo>
}

class MediaRemoteDataSourceImpl
@Inject
constructor(private val api: MediaApi) : MediaRemoteDataSource {

    override suspend fun getAlbums(): List<Album> =
            api.getAlbums().map { it.toDomain() }

    override suspend fun getPhotos(albumId: Int): List<Photo> =
            api.getPhotos(albumId).map { it.toDomain() }
}