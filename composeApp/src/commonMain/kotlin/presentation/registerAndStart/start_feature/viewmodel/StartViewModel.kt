package org.example.project.presentation.registerAndStart.start_feature.viewmodel

import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.registerAndStart.start_feature.viewmodel.intents.StartIntent

class StartViewModel(val date: StaticDateApi):ViewModel() {
 fun processIntent(intent: StartIntents){
     when(intent) {
         is StartIntents.Start -> {StartIntent.execute()}
     }
 }
}