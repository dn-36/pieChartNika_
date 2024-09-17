package org.example.project.presentation.add_transaction.date_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateViewModel

object OpenYearIntent {
    fun execute(){
        if(DateViewModel.dateState.alphaYear.value == 0f){
            DateViewModel.dateState = DateViewModel.dateState.copy(
                alphaYear = mutableStateOf(1f),
                alphaTextYear = mutableStateOf(0f),
                rotateYear = mutableStateOf(90f)
            )
        }
        else{
            DateViewModel.dateState = DateViewModel.dateState.copy(
                alphaYear = mutableStateOf(0f),
                alphaTextYear = mutableStateOf(1f),
                rotateYear = mutableStateOf(270f)
            )
        }
    }
}