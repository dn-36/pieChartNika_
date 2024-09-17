package org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel.intents.NoThanksIntent
import org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel.intents.SetAddPhotosIntent

class AddPhotoViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var addPhotosState by mutableStateOf(AddPhotosState())
    }
    fun processIntent(intents: AddPhotoIntents){
        when(intents){
            is AddPhotoIntents.NoThanks -> {NoThanksIntent.execute(intents.image)}
            is AddPhotoIntents.SetScreen -> {SetAddPhotosIntent.execute(intents.image)}
        }
    }
}