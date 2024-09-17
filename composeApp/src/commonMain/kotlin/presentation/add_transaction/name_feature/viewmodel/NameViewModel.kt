package org.example.project.presentation.add_transaction.name_feature.viewmodel

import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.add_transaction.name_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.add_transaction.name_feature.viewmodel.intents.NextIntent

class NameViewModel(val date: StaticDateApi): ViewModel() {
    fun processIntent(intents: NameIntents){
        when(intents){
            is NameIntents.Back -> {BackIntent.execute()}
            is NameIntents.Next -> {NextIntent.execute(intents.name)}
        }
    }
}