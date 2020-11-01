package com.zalesskyi.domain.usecases

import com.zalesskyi.domain.base.UseCaseCoroutine
import com.zalesskyi.domain.models.Album
import com.zalesskyi.domain.repository.MediaRepository
import javax.inject.Inject

class GetAlbumsUseCase
@Inject
constructor(private val repository: MediaRepository) : UseCaseCoroutine<List<Album>, Unit>() {

    override suspend fun executeOnBackground(params: Unit): List<Album> = repository.getAlbums()
}