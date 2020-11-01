package com.zalesskyi.photogallery.presentation.main.details

import com.zalesskyi.photogallery.presentation.base.BaseViewModel
import com.zalesskyi.photogallery.presentation.base.BaseViewModelImpl
import javax.inject.Inject

interface DetailsViewModel : BaseViewModel

class DetailsViewModelImpl
@Inject
constructor() : BaseViewModelImpl(), DetailsViewModel