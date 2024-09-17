package org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.intents.BackButtonIntent
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.intents.ChoosingCategoryIntent
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.intents.NextIntent

class ChoosingCategoryViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var choosingCategoryState by mutableStateOf(ChoosingCategoryState())
    }
    fun processIntent(intents: ChoosingCategoryIntents){
        when(intents){
            is ChoosingCategoryIntents.ChoosingCategory -> {ChoosingCategoryIntent.execute(intents.index,intents.category)}
            is ChoosingCategoryIntents.Next -> {NextIntent.execute()}
            is ChoosingCategoryIntents.Back -> {BackButtonIntent.execute()}
        }
    }
}