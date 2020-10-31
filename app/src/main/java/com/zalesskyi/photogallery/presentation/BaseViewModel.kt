package com.zalesskyi.photogallery.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zalesskyi.domain.base.CompletionBlock
import com.zalesskyi.domain.base.UseCaseCoroutine
import kotlinx.coroutines.launch

interface BaseViewModel

open class BaseViewModelImpl : ViewModel(), BaseViewModel {

    fun <T, R, U : UseCaseCoroutine<T, R>>U.launch(param: R, block: CompletionBlock<T>) {
        viewModelScope.launch { execute(param, block) }
    }
}