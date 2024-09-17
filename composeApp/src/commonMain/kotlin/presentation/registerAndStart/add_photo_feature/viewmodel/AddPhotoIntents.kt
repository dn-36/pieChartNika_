package org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel

import androidx.compose.ui.graphics.ImageBitmap

sealed class AddPhotoIntents {
    data class NoThanks(val image:MutableList<ImageBitmap>):AddPhotoIntents()
    data class SetScreen(val image:MutableList<ImageBitmap>):AddPhotoIntents()
}