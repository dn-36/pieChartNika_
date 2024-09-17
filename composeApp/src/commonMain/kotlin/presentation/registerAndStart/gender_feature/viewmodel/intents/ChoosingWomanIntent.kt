package org.example.project.presentation.registerAndStart.gender_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import org.example.project.presentation.registerAndStart.gender_feature.viewmodel.GenderViewModel

object ChoosingWomanIntent {
    fun execute(){
        if(GenderViewModel.genderState.colorWoman.value == Color(0xFFD8D8D8)) {
            GenderViewModel.genderState = GenderViewModel.genderState.copy(
                colorWoman = mutableStateOf(Color(0xFFF8DB1C)),
                colorMan = mutableStateOf(Color(0xFFD8D8D8))
            )
        }
        else{
            GenderViewModel.genderState = GenderViewModel.genderState.copy(
                colorWoman = mutableStateOf(Color(0xFFD8D8D8))
            )
        }
    }
}