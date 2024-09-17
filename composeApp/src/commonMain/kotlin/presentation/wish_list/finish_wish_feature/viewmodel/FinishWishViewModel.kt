package org.example.project.presentation.wish_list.finish_wish_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.intents.DoneIntent
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.intents.SetFinishWishIntent

class FinishWishViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var finishWishState by mutableStateOf(FinishWishState())
    }
    fun processIntent(intents: FinishWishIntents){
        when(intents){
            is FinishWishIntents.Done -> {DoneIntent.execute()}
            is FinishWishIntents.SetScreen -> {SetFinishWishIntent.execute()}
        }
    }
}