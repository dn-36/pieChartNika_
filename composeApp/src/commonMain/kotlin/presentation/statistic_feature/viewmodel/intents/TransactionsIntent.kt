package org.example.project.presentation.statistic_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel

object TransactionsIntent {
    fun execute(){
        StatisticViewModel.statisticState = StatisticViewModel.statisticState.copy(
            diagram = mutableStateOf(0f),
            moneyBox = mutableStateOf(0f),
            transactions = mutableStateOf(1f)
        )
        StatisticViewModel(StaticDate).date.isUsedTransactions.value = true
    }
}