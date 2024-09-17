package org.example.project.presentation.wish_list.already_accumulated_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wish_list.already_accumulated_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.wish_list.already_accumulated_feature.viewmodel.intents.NextIntent

class AlreadyAccumulatedViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var alreadyAccumulatedState by mutableStateOf(AlreadyAccumulatedState())
    }
    fun processIntent(intents: AlreadyAccumulatedIntents){
        when(intents){
            is AlreadyAccumulatedIntents.Back -> {BackIntent.execute()}
            is AlreadyAccumulatedIntents.Next -> {NextIntent.execute(intents.already)}
        }
    }
}