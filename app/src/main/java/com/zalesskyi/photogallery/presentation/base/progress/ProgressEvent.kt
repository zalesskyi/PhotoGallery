package com.zalesskyi.photogallery.presentation.base.progress

sealed class ProgressEvent {
    object Show : ProgressEvent()
    object Hide : ProgressEvent()

    val inProgress get()  = this is Show
}