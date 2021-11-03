package com.home.imagesearchapp.ui.gallery

import androidx.lifecycle.ViewModel
import com.home.imagesearchapp.data.UnsplashResository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: UnsplashResository
) : ViewModel() {

}