package com.zalesskyi.photogallery.presentation.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zalesskyi.domain.base.CompletionBlock
import com.zalesskyi.domain.base.UseCaseCoroutine
import com.zalesskyi.photogallery.android.system.tools.SingleLiveEvent
import com.zalesskyi.photogallery.presentation.base.progress.ProgressEvent
import kotlinx.coroutines.launch

interface BaseViewModel {

    val progressLiveData: LiveData<ProgressEvent>

    val errorLiveData: LiveData<Throwable>
}

open class BaseViewModelImpl : ViewModel(), BaseViewModel {

    override val progressLiveData = SingleLiveEvent<ProgressEvent>()

    override val errorLiveData = SingleLiveEvent<Throwable>()

    fun <T, R, U : UseCaseCoroutine<T, R>>U.launch(param: R, block: CompletionBlock<T>) {
        viewModelScope.launch { execute(param, block) }
    }

    @CallSuper
    protected open fun showProgress() {
        progressLiveData.value = ProgressEvent.Show
    }

    @CallSuper
    protected open fun hideProgress() {
        progressLiveData.value = ProgressEvent.Hide
    }
}