package com.home.imagesearchapp.api

import com.home.imagesearchapp.data.UnsplashPhotoObject

data class UnsplashResponse(
    val results: List<UnsplashPhotoObject>
)