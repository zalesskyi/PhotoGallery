package com.zalesskyi.photogallery.presentation.main.photos

import com.zalesskyi.photogallery.presentation.base.BaseViewModel
import com.zalesskyi.photogallery.presentation.base.BaseViewModelImpl
import javax.inject.Inject

interface PhotosListViewModel : BaseViewModel

class PhotosListViewModelImpl
@Inject
constructor() : BaseViewModelImpl(), PhotosListViewModel