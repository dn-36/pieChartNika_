package org.example.project.presentation.add_transaction.date_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.add_transaction.date_feature.viewmodel.intents.NextIntent
import org.example.project.presentation.add_transaction.date_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.add_transaction.date_feature.viewmodel.intents.ChoosingDayIntent
import org.example.project.presentation.add_transaction.date_feature.viewmodel.intents.ChoosingMonthIntent
import org.example.project.presentation.add_transaction.date_feature.viewmodel.intents.ChoosingYearIntent
import org.example.project.presentation.add_transaction.date_feature.viewmodel.intents.OpenDayIntent
import org.example.project.presentation.add_transaction.date_feature.viewmodel.intents.OpenMonthIntent
import org.example.project.presentation.add_transaction.date_feature.viewmodel.intents.OpenYearIntent

class DateViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var dateState by mutableStateOf(DateState())
    }
    fun processIntent(intents: DateIntents){
        when(intents){
            is DateIntents.Next -> {NextIntent.execute()}
            is DateIntents.Back -> {BackIntent.execute()}
            is DateIntents.OpenDay -> {OpenDayIntent.execute()}
            is DateIntents.OpenMonth -> {OpenMonthIntent.execute()}
            is DateIntents.OpenYear -> {OpenYearIntent.execute()}
            is DateIntents.ChoosingMonth -> {ChoosingMonthIntent.execute(intents.month)}
            is DateIntents.ChoosingDay -> {ChoosingDayIntent.execute(intents.day)}
            is DateIntents.ChoosingYear -> {ChoosingYearIntent.execute(intents.year)}
        }
    }
}