package org.example.project.presentation.add_transaction.date_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateViewModel

object OpenDayIntent {
    fun execute(){
        if(DateViewModel.dateState.alphaDay.value == 0f){
            DateViewModel.dateState = DateViewModel.dateState.copy(
                alphaDay = mutableStateOf(1f),
                alphaTextDay = mutableStateOf(0f),
                rotateDay = mutableStateOf(90f)
            )
        }
        else{
            DateViewModel.dateState = DateViewModel.dateState.copy(
                alphaDay = mutableStateOf(0f),
                alphaTextDay = mutableStateOf(1f),
                rotateDay = mutableStateOf(270f)
            )
        }
    }
}