package org.example.project.presentation.wish_list.amount_savings_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wish_list.amount_savings_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.wish_list.amount_savings_feature.viewmodel.intents.NextIntent

class AmountSavingsViewModel(val date: StaticDateApi): ViewModel() {
companion object{
    var amountSavingsState by mutableStateOf(AmountSavingsState())
}
    fun processIntent(intents: AmountSavingsIntents){
        when(intents){
            is AmountSavingsIntents.Back -> {BackIntent.execute()}
            is AmountSavingsIntents.Next -> {NextIntent.execute(intents.amount)}
        }
    }
}