package com.zalesskyi.photogallery.presentation.splash

import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.presentation.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashViewModel>() {

    override val layoutResId = R.layout.activity_splash

    override val viewModel: SplashViewModel by inject<SplashViewModelImpl>()

    @Inject
    lateinit var navigator: SplashNavigator

    override fun observeViewModel() = Unit

    override fun onResume() {
        super.onResume()
        navigator.toMain()
    }
}