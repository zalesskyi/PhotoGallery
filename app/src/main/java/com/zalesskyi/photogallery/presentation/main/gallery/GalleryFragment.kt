package com.zalesskyi.photogallery.presentation.main.gallery

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.observe
import com.zalesskyi.domain.models.Album
import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.extensions.gone
import com.zalesskyi.photogallery.extensions.skeleton
import com.zalesskyi.photogallery.extensions.visible
import com.zalesskyi.photogallery.presentation.base.BaseFragment
import com.zalesskyi.photogallery.presentation.main.MainNavigator
import kotlinx.android.synthetic.main.fragment_gallery.*
import javax.inject.Inject

class GalleryFragment : BaseFragment<GalleryViewModel>() {

    override val viewModel: GalleryViewModel by inject<GalleryViewModelImpl>()

    @Inject
    lateinit var navigator: MainNavigator

    override fun getLayout(): Int = R.layout.fragment_gallery

    private val adapter: AlbumsAdapter by lazy {
        AlbumsAdapter(listOf()) { albumId ->
            navigator.toAlbumDetails(albumId)
        }
    }

    override fun observeViewModel() {
        viewModel.run {
            albumsLiveData.observe(viewLifecycleOwner, ::onArrived)
            errorLiveData.observe(viewLifecycleOwner) {
                lawErrorGallery.visible()
                rvAlbums.gone()
            }
        }
    }

    override fun skeletonVisible(visible: Boolean) {
        super.skeletonVisible(visible)
        adapter.takeIf { isVisible }?.updateAllNotify(listOf<Parcelable>().skeleton())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvAlbums.adapter = adapter
        viewModel.getAlbums()
    }

    private fun onArrived(data: List<Album>) {
        lawErrorGallery.gone()
        rvAlbums.visible()
        adapter.updateAllNotify(data)
    }
}