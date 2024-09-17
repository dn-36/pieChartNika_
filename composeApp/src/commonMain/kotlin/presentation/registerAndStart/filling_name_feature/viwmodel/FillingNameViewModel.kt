package org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel.intents.NextIntent

class FillingNameViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var fillingNameState by mutableStateOf(FillingNameState())
    }
    fun processIntent(intents: FillingNameIntents){
        when(intents){
            is FillingNameIntents.Next -> {NextIntent.execute(intents.name)}
        }
    }
}