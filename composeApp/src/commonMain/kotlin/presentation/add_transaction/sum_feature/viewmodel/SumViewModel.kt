package org.example.project.presentation.add_transaction.sum_feature.viewmodel

import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.add_transaction.sum_feature.viewmodel.intents.NextIntent
import org.example.project.presentation.add_transaction.sum_feature.viewmodel.intents.BackIntent

class SumViewModel(val date: StaticDateApi): ViewModel() {
    fun processIntent(intents: SumIntents){
        when(intents){
            is SumIntents.Back -> {BackIntent.execute()}
            is SumIntents.Next -> {NextIntent.execute(intents.sum)}
        }
    }
}