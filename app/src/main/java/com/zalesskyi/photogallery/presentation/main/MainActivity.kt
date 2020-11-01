package com.zalesskyi.photogallery.presentation.main

import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.navigation.AppNavProvider
import com.zalesskyi.photogallery.presentation.BaseActivity

class MainActivity : BaseActivity<MainViewModel>(), AppNavProvider {

    companion object {

        fun getIntent(context: Context) =
                Intent(context, MainActivity::class.java)
    }

    override val layoutResId = R.layout.activity_main

    override val viewModel: MainViewModel by inject<MainViewModelImpl>()

    override fun observeViewModel() = Unit

    override fun getNavController(): NavController = findNavController(R.id.nav_host_fragment)
}