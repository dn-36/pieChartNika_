package org.example.project.presentation.registerAndStart.gender_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.registerAndStart.gender_feature.viewmodel.intents.ChoosingManIntent
import org.example.project.presentation.registerAndStart.gender_feature.viewmodel.intents.ChoosingWomanIntent
import org.example.project.presentation.registerAndStart.gender_feature.viewmodel.intents.NextIntent

class GenderViewModel(val date: StaticDateApi): ViewModel() {
    companion object {
        var genderState by mutableStateOf(GenderState())
    }
    fun processIntent(intents: GenderIntents){
        when(intents){
            is GenderIntents.ChoosingMan -> {ChoosingManIntent.execute()}
            is GenderIntents.ChoosingWoman -> { ChoosingWomanIntent.execute() }
            is GenderIntents.Next -> { NextIntent.execute() }
        }
    }
}