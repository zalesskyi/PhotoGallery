package com.zalesskyi.photogallery.presentation.splash

import com.zalesskyi.photogallery.presentation.BaseViewModel
import com.zalesskyi.photogallery.presentation.BaseViewModelImpl
import javax.inject.Inject

interface SplashViewModel : BaseViewModel

class SplashViewModelImpl
@Inject
constructor() : BaseViewModelImpl(), SplashViewModel