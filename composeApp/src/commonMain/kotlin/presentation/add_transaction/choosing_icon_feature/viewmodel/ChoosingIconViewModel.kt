package org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.intents.ChoosingIconIntent
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.intents.NextIntent

class ChoosingIconViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var choosingIconState by mutableStateOf(ChoosingIconState())
    }
    fun processIntent(intents: ChoosingIconIntents){
        when(intents){
            is ChoosingIconIntents.ChoosingIcon -> {ChoosingIconIntent.execute(intents.index,intents.image)}
            is ChoosingIconIntents.Back -> {BackIntent.execute()}
            is ChoosingIconIntents.Next -> {NextIntent.execute()}
        }
    }
}