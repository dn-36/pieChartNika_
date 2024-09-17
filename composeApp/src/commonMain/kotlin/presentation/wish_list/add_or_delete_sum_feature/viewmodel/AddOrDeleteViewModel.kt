package org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.intents.DoneIntent
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.intents.AddIntent
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.intents.DeleteIntent

class AddOrDeleteViewModel(val date: StaticDateApi): ViewModel()  {
    companion object{
        var addOrDeleteState by mutableStateOf(AddOrDeleteState())
    }
    fun processIntent(intents: AddOrDeleteIntents){
        when(intents){
            is AddOrDeleteIntents.Done -> {DoneIntent.execute(intents.sum)}
            is AddOrDeleteIntents.Back -> {BackIntent.execute()}
            is AddOrDeleteIntents.Delete -> {DeleteIntent.execute()}
            is AddOrDeleteIntents.Add -> {AddIntent.execute()}
        }
    }
}