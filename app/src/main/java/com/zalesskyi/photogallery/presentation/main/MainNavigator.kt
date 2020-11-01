package com.zalesskyi.photogallery.presentation.main

import com.zalesskyi.photogallery.navigation.NavigationCommand
import com.zalesskyi.photogallery.navigation.Navigator
import com.zalesskyi.photogallery.presentation.main.gallery.GalleryFragmentDirections
import com.zalesskyi.photogallery.presentation.main.photos.PhotosListFragmentDirections
import javax.inject.Inject
import javax.inject.Named

interface MainNavigator {

    fun toAlbumDetails(albumId: Int)

    fun toPhotoDetail(albumId: Int, photoUrl: String)
}

class MainNavigatorImpl
@Inject
constructor(@Named(APP_NAVIGATOR)
            private val navigator: Navigator,
            @Named(APP_NAV_NAVIGATOR)
            private val appNavigator: Navigator) : MainNavigator {

    companion object {
        const val APP_NAVIGATOR = "MainNavigator.APP_NAVIGATOR"
        const val APP_NAV_NAVIGATOR = "MainNavigator.APP_NAV_NAVIGATOR"
    }

    override fun toAlbumDetails(albumId: Int) {
        appNavigator.navigate(NavigationCommand.ToDirections(
            GalleryFragmentDirections.actionGalleryFragmentToPhotosFragment(albumId)))
    }

    override fun toPhotoDetail(albumId: Int, photoUrl: String) {
        appNavigator.navigate(NavigationCommand.ToDirections(
            PhotosListFragmentDirections.actionPhotosFragmentToDetailsFragment(albumId, photoUrl)
        ))
    }
}