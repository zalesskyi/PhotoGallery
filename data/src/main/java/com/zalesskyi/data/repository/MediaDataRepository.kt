package com.zalesskyi.data.repository

import com.zalesskyi.data.datasource.MediaRemoteDataSource
import com.zalesskyi.domain.models.Album
import com.zalesskyi.domain.models.Photo
import com.zalesskyi.domain.repository.MediaRepository
import javax.inject.Inject

class MediaDataRepository
@Inject
constructor(private val source: MediaRemoteDataSource) : MediaRepository {

    override suspend fun getAlbums(): List<Album> = source.getAlbums()

    override suspend fun getPhotos(albumId: Int): List<Photo> = source.getPhotos(albumId)
}