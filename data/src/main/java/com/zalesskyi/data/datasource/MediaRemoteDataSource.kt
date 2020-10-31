package com.zalesskyi.data.datasource

import com.zalesskyi.data.network.api.MediaApi
import javax.inject.Inject

interface MediaRemoteDataSource

class MediaRemoteDataSourceImpl
@Inject
constructor(private val api: MediaApi): MediaRemoteDataSource {


}