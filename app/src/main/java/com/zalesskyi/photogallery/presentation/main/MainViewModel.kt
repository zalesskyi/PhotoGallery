package com.zalesskyi.photogallery.presentation.main

import com.zalesskyi.photogallery.presentation.BaseViewModel
import com.zalesskyi.photogallery.presentation.BaseViewModelImpl
import javax.inject.Inject

interface MainViewModel : BaseViewModel

class MainViewModelImpl
@Inject
constructor() : BaseViewModelImpl(), MainViewModel