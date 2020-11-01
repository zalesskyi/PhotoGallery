package com.zalesskyi.photogallery.presentation.base

import android.os.Bundle
import android.widget.PopupWindow
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.zalesskyi.photogallery.android.system.ContextHolder
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<out VM : BaseViewModel> : AppCompatActivity(),
        HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @get:LayoutRes
    protected abstract val layoutResId: Int?
    protected abstract val viewModel: VM

    protected open var onFragmentChanged: ((Fragment) -> Unit)? = null

    @Inject
    lateinit var contextHolder: ContextHolder

    private var progressPopup: PopupWindow? = null

    abstract fun observeViewModel()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        observeViewModel()
        super.onCreate(savedInstanceState)
        layoutResId?.let(::setContentView)
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        contextHolder.insertContext(this)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        onFragmentChanged = null
    }

    override fun androidInjector() = dispatchingAndroidInjector

    inline fun <reified VM : ViewModel> inject(): Lazy<VM> = lazy {
        ViewModelProvider(this, viewModelFactory).get(VM::class.java)
    }

    // Private

    private fun showSnackMessage(@StringRes message: Int) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }
}