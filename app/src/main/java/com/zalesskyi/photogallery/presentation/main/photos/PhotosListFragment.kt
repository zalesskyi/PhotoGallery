package com.zalesskyi.photogallery.presentation.main.photos

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.zalesskyi.domain.models.Photo
import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.extensions.gone
import com.zalesskyi.photogallery.extensions.skeleton
import com.zalesskyi.photogallery.extensions.visible
import com.zalesskyi.photogallery.presentation.base.BaseFragment
import com.zalesskyi.photogallery.presentation.base.progress.ProgressEvent
import com.zalesskyi.photogallery.presentation.main.MainNavigator
import com.zalesskyi.photogallery.presentation.main.MainViewModel
import com.zalesskyi.photogallery.presentation.main.MainViewModelImpl
import kotlinx.android.synthetic.main.fragment_photos.*
import javax.inject.Inject

class PhotosListFragment : BaseFragment<PhotosListViewModel>() {

    override val viewModel: PhotosListViewModel by inject<PhotosListViewModelImpl>()

    @Inject
    lateinit var navigator: MainNavigator

    private val args by navArgs<PhotosListFragmentArgs>()

    private val mainViewModel: MainViewModel by injectSharedFromActivity<MainViewModelImpl>()

    override fun getLayout(): Int = R.layout.fragment_photos

    private val adapter: PhotosAdapter by lazy {
        PhotosAdapter(listOf()) { photo ->
            photo.run {
                navigator.toPhotoDetail(albumId, url)
            }
        }
    }

    override fun observeViewModel() {
        mainViewModel.run {
            photosLiveData.observe(viewLifecycleOwner) { gallery ->
                gallery[args.albumId]?.let(::onArrived)
            }
            mainViewModel.progressLiveData.observe(viewLifecycleOwner) {
                when (it) {
                    ProgressEvent.Show -> showProgress()
                    ProgressEvent.Hide -> hideProgress()
                }
            }
            mainViewModel.errorLiveData.observe(viewLifecycleOwner) {
                lawError.visible()
                rvPhotos.gone()
            }
        }
    }

    override fun skeletonVisible(visible: Boolean) {
        super.skeletonVisible(visible)
        adapter.updateAllNotify(listOf<Parcelable>().skeleton())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPhotos.adapter = adapter
        mainViewModel.getPhotos(args.albumId)
    }

    private fun onArrived(data: List<Photo>) {
        lawError.gone()
        rvPhotos.visible()
        adapter.updateAllNotify(data)
    }
}