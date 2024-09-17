package org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel.intents

import androidx.compose.ui.graphics.ImageBitmap
import org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel.AddPhotoViewModel
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.done_button

object SetAddPhotosIntent {
    fun execute(image:MutableList<ImageBitmap>){
        if(image.size != 0) {
            AddPhotoViewModel.addPhotosState.button.value = Res.drawable.done_button
        }
    }
}