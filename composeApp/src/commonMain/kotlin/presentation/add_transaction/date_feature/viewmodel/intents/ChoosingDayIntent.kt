package org.example.project.presentation.add_transaction.date_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateViewModel

object ChoosingDayIntent {
    fun execute(day:String){
        DateViewModel.dateState = DateViewModel.dateState.copy(
            textDay = mutableStateOf(day),
            alphaDay = mutableStateOf(0f),
            alphaTextDay = mutableStateOf(1f),
            rotateDay = mutableStateOf(270f)
        )
    }
}