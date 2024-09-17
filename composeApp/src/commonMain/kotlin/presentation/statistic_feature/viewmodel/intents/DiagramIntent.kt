package org.example.project.presentation.statistic_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel

object DiagramIntent {
    fun execute(){
        StatisticViewModel.statisticState = StatisticViewModel.statisticState.copy(
            diagram = mutableStateOf(1f),
            moneyBox = mutableStateOf(0f),
            transactions = mutableStateOf(0f)
        )
        StatisticViewModel(StaticDate).date.isUsedStatistic.value = true

    }
}