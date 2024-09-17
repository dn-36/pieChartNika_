package org.example.project.presentation.add_transaction.finish_fetaure.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.add_transaction.finish_fetaure.viewmodel.intents.FinishIntent
import org.example.project.presentation.add_transaction.finish_fetaure.viewmodel.intents.SetFinishIntent

class FinishViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var finishState by mutableStateOf(FinishState())
    }
    fun processIntent(intents: FinishIntents){
        when(intents){
            is FinishIntents.Finish -> {FinishIntent.execute()}
            is FinishIntents.SetScreen -> {SetFinishIntent.execute()}
        }
    }
}