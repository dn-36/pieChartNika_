package org.example.project.presentation.add_transaction.date_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateViewModel

object ChoosingMonthIntent {
    fun execute(month:String){
        DateViewModel.dateState = DateViewModel.dateState.copy(
            textMonth = mutableStateOf(month),
            alphaMonth = mutableStateOf(0f),
            alphaTextMonth = mutableStateOf(1f),
            rotateMonth = mutableStateOf(270f)
        )
    }
}