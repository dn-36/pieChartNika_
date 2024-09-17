package org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.add_photo_feature.screen.AddPhotoScreen
import org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel.FillingNameViewModel

object NextIntent {
    fun execute(name:String){
        if(name.length == 0){
         FillingNameViewModel.fillingNameState = FillingNameViewModel.fillingNameState.copy(
             toast = mutableStateOf(true)
         )
        }
        else{
        StaticDate.navigator.push(AddPhotoScreen)
            FillingNameViewModel(StaticDate).date.name = name
        }
    }
}