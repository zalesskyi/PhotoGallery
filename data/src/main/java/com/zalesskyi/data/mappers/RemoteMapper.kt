package com.zalesskyi.data.mappers

import com.zalesskyi.data.network.models.AlbumResponse
import com.zalesskyi.data.network.models.PhotoResponse
import com.zalesskyi.domain.models.Album
import com.zalesskyi.domain.models.Photo

fun PhotoResponse.toDomain() = Photo(albumId, id, title, url, thumbUrl)

fun AlbumResponse.toDomain() = Album(id, title)