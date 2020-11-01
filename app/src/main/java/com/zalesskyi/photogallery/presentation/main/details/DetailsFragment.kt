package com.zalesskyi.photogallery.presentation.main.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.zalesskyi.domain.models.Photo
import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.presentation.base.BaseFragment
import com.zalesskyi.photogallery.presentation.main.MainViewModel
import com.zalesskyi.photogallery.presentation.main.MainViewModelImpl
import com.zalesskyi.photogallery.utils.NO_POSITION
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : BaseFragment<DetailsViewModel>() {

    override val viewModel: DetailsViewModel by inject<DetailsViewModelImpl>()

    private val args by navArgs<DetailsFragmentArgs>()

    private val mainViewModel: MainViewModel by injectSharedFromActivity<MainViewModelImpl>()

    override fun getLayout(): Int = R.layout.fragment_details

    override fun observeViewModel() = Unit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.photosLiveData.value?.get(args.albumId)?.let(::initPager)
    }

    private fun initPager(photos: List<Photo>) {
        vpDetail.adapter = CardStackAdapter(photos)
        photos.indexOfFirst { it.url == args.photoUrl }
            .takeIf { it != NO_POSITION }?.let {
                vpDetail.setCurrentItem(it, false)
            }
    }
}