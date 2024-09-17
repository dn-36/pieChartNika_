package org.example.project.presentation.statistic_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.statistic_feature.viewmodel.intents.DiagramIntent
import org.example.project.presentation.statistic_feature.viewmodel.intents.MinusIndexMonthIntent
import org.example.project.presentation.statistic_feature.viewmodel.intents.MoneyBoxIntent
import org.example.project.presentation.statistic_feature.viewmodel.intents.PlusIndexMonthIntent
import org.example.project.presentation.statistic_feature.viewmodel.intents.SetDiagramIntent
import org.example.project.presentation.statistic_feature.viewmodel.intents.SetTransactionsIntent
import org.example.project.presentation.statistic_feature.viewmodel.intents.TransactionsIntent

class StatisticViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var statisticState by mutableStateOf(StatisticState())
    }
    fun processIntent(intents: StatisticIntents){
        when(intents){
            is StatisticIntents.Diagram -> {DiagramIntent.execute()}
            is StatisticIntents.MoneyBox -> {MoneyBoxIntent.execute()}
            is StatisticIntents.Transaction -> {TransactionsIntent.execute()}
            is StatisticIntents.PlusIndexMonth-> {PlusIndexMonthIntent.execute()}
            is StatisticIntents.MinusIndexMonth -> {MinusIndexMonthIntent.execute()}
            is StatisticIntents.SetDiagram -> {SetDiagramIntent.execute()}
            is StatisticIntents.SetTransactions -> {SetTransactionsIntent.execute()}
        }
    }
}