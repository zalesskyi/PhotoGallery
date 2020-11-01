package com.zalesskyi.photogallery.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.zalesskyi.photogallery.extensions.visible
import com.zalesskyi.photogallery.presentation.base.progress.ProgressEvent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<out VM : BaseViewModel> : Fragment(),
        HasAndroidInjector {

    companion object {

        const val NO_TITLE = -1
        private const val DEBOUNCE_TIME_MS = 300L
    }

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewModel: VM

    protected open val titleRes: Int = NO_TITLE
    protected open val skeletonViews = listOf<View?>()
    protected open val contentViews = listOf<View?>()
    protected open val softInputType: Int? get() = activity?.window?.attributes?.softInputMode

    @LayoutRes
    protected abstract fun getLayout(): Int

    protected abstract fun observeViewModel()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        subscribe()
    }

    override fun androidInjector() = fragmentInjector

    protected open fun showProgress() {
        skeletonVisible(true)
        contentVisible(false)
    }

    protected open fun hideProgress() {
        skeletonVisible(false)
        contentVisible(true)
    }

    protected open fun contentVisible(visible: Boolean) =
            contentViews.forEach { it?.visible(visible) }

    protected open fun skeletonVisible(visible: Boolean) =
            skeletonViews.forEach { it?.visible(visible) }

    private fun subscribe() {
        viewModel.progressLiveData.observe(viewLifecycleOwner) {
            when (it) {
                ProgressEvent.Show -> showProgress()
                ProgressEvent.Hide -> hideProgress()
            }
        }
    }

    inline fun <reified VM : ViewModel> inject() = lazy {
        ViewModelProvider(this, viewModelFactory)
                .get(VM::class.java)
    }

    inline fun <reified VM : ViewModel> injectSharedFromActivity() = lazy {
        (activity?.let { ViewModelProvider(it, viewModelFactory) }
                ?: ViewModelProvider(this, viewModelFactory)).get(VM::class.java)
    }

    inline fun <reified VM : ViewModel> injectSharedFromParentFragment() = lazy {
        ViewModelProvider(parentFragment ?: this, viewModelFactory)
                .get(VM::class.java)
    }
}