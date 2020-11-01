package com.zalesskyi.domain.usecases

import com.zalesskyi.domain.base.UseCaseCoroutine
import com.zalesskyi.domain.models.Photo
import com.zalesskyi.domain.repository.MediaRepository
import javax.inject.Inject

class GetPhotosUseCase
@Inject
constructor(private val repository: MediaRepository) : UseCaseCoroutine<List<Photo>, Int>() {

    override suspend fun executeOnBackground(params: Int): List<Photo> = repository.getPhotos(params)
}