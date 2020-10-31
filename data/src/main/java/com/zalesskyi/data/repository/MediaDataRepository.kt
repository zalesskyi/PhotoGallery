package com.zalesskyi.data.repository

import com.zalesskyi.data.datasource.MediaRemoteDataSource
import com.zalesskyi.domain.repository.MediaRepository
import javax.inject.Inject

class MediaDataRepository
@Inject
constructor(private val source: MediaRemoteDataSource) : MediaRepository