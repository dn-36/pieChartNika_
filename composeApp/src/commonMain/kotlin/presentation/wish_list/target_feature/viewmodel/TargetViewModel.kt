package org.example.project.presentation.wish_list.target_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wish_list.target_feature.viewmodel.intents.NextIntent
import org.example.project.presentation.wish_list.target_feature.viewmodel.intents.BackIntent

class TargetViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var targetState by mutableStateOf(TargetState())
    }
    fun processIntent(intents: TargetIntents){
        when(intents){
            is TargetIntents.Next -> {NextIntent.execute(intents.target)}
            is TargetIntents.Back -> {BackIntent.execute()}
        }
    }
}