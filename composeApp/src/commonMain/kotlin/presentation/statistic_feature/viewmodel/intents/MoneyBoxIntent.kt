package org.example.project.presentation.statistic_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel

object MoneyBoxIntent {
    fun execute(){
        StatisticViewModel.statisticState = StatisticViewModel.statisticState.copy(
            diagram = mutableStateOf(0f),
            moneyBox = mutableStateOf(1f),
            transactions = mutableStateOf(0f)
        )
    }
}