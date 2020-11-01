package com.zalesskyi.photogallery.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zalesskyi.domain.models.Photo
import com.zalesskyi.domain.usecases.GetPhotosUseCase
import com.zalesskyi.photogallery.extensions.notifyObserver
import com.zalesskyi.photogallery.presentation.base.BaseViewModel
import com.zalesskyi.photogallery.presentation.base.BaseViewModelImpl
import javax.inject.Inject

interface MainViewModel : BaseViewModel {

    /**
     * Photos for each loaded album.
     * Key - album id;
     * Value - photos of this album.
     */
    val photosLiveData: LiveData<MutableMap<Int, List<Photo>>>

    fun getPhotos(albumId: Int)
}

class MainViewModelImpl
@Inject
constructor(private val getPhotosUseCase: GetPhotosUseCase) : BaseViewModelImpl(), MainViewModel {

    override val photosLiveData = MutableLiveData(mutableMapOf<Int, List<Photo>>())

    override fun getPhotos(albumId: Int) {
        getPhotosUseCase.launch(albumId) {
            onStart = {
                showProgress()
            }
            onCancel = {
                hideProgress()
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
                photosLiveData.run {
                    value?.put(albumId, it)
                    notifyObserver()
                }
            }
        }
    }
}