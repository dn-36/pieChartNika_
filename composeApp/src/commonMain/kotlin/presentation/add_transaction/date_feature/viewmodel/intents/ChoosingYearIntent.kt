package org.example.project.presentation.add_transaction.date_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateViewModel

object ChoosingYearIntent {
    fun execute(year:String){
        DateViewModel.dateState = DateViewModel.dateState.copy(
            textYear = mutableStateOf(year),
            alphaYear = mutableStateOf(0f),
            alphaTextYear = mutableStateOf(1f),
            rotateYear = mutableStateOf(270f)
        )
    }
}