package org.example.project.presentation.registerAndStart.welcome_feature.viewmodel

import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.registerAndStart.welcome_feature.viewmodel.inetnts.StartIntent

class WelcomeViewModel(val date: StaticDateApi): ViewModel() {
    fun processIntent(intent: WelcomeIntents){
        when(intent){
            is WelcomeIntents.Start -> {StartIntent.execute()}
        }
    }
}