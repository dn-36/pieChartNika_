package org.example.project.presentation.add_transaction.date_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateViewModel

object OpenMonthIntent {
    fun execute(){
        if(DateViewModel.dateState.alphaMonth.value == 0f){
            DateViewModel.dateState = DateViewModel.dateState.copy(
                alphaMonth = mutableStateOf(1f),
                alphaTextMonth = mutableStateOf(0f),
                rotateMonth = mutableStateOf(90f)
            )
        }
        else{
            DateViewModel.dateState = DateViewModel.dateState.copy(
                alphaMonth = mutableStateOf(0f),
                alphaTextMonth = mutableStateOf(1f),
                rotateMonth = mutableStateOf(270f)
            )
        }
    }
}