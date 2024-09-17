package org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel.intents

import androidx.compose.ui.graphics.ImageBitmap
import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel.AddPhotoViewModel
import org.example.project.presentation.registerAndStart.gender_feature.screen.GenderScreen

object NoThanksIntent {
    fun execute(image:MutableList<ImageBitmap>){
        if(image.size != 0){
        AddPhotoViewModel(StaticDate).date.photo = image[0]}
        StaticDate.navigator.push(GenderScreen)
    }
}