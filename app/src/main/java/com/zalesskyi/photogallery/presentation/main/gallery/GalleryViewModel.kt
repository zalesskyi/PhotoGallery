package com.zalesskyi.photogallery.presentation.main.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zalesskyi.domain.models.Album
import com.zalesskyi.domain.usecases.GetAlbumsUseCase
import com.zalesskyi.photogallery.presentation.base.BaseViewModel
import com.zalesskyi.photogallery.presentation.base.BaseViewModelImpl
import javax.inject.Inject

interface GalleryViewModel : BaseViewModel {

    val albumsLiveData: LiveData<List<Album>>

    fun getAlbums()
}

class GalleryViewModelImpl
@Inject
constructor(private val getAlbumsUseCase: GetAlbumsUseCase) : BaseViewModelImpl(), GalleryViewModel {

    override val albumsLiveData = MutableLiveData<List<Album>>()

    override fun getAlbums() {
        getAlbumsUseCase.launch(Unit) {
            onStart = {
                showProgress()
            }
            onCancel = {
                hideProgress()
                errorLiveData.value = it
            }
            onError = {
                hideProgress()
                errorLiveData.value = it
            }
            onComplete = {
                hideProgress()
                albumsLiveData.value = it
            }
        }
    }
}