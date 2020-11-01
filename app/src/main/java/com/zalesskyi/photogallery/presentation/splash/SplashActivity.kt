package com.zalesskyi.photogallery.presentation.splash

import android.os.Bundle
import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashViewModel>() {

    companion object {

        private const val FINISH_PERCENT = 0.6F
    }

    override val layoutResId = R.layout.activity_splash

    override val viewModel: SplashViewModel by inject<SplashViewModelImpl>()

    @Inject
    lateinit var navigator: SplashNavigator

    override fun observeViewModel() = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lawSplash?.addAnimatorUpdateListener { animator ->
            if ((animator.animatedValue as Float) > FINISH_PERCENT) {
                lawSplash?.cancelAnimation()
                finishSplash()
            }
        }
    }

    private fun finishSplash() {
        navigator.toMain()
        finish()
    }
}