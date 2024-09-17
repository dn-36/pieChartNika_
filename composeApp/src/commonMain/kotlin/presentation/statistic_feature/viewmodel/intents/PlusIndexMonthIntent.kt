package org.example.project.presentation.statistic_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel

object PlusIndexMonthIntent {
    fun execute(){
        if(StatisticViewModel.statisticState.index.value == 11){
            StatisticViewModel.statisticState = StatisticViewModel.statisticState.copy(
                index = mutableStateOf(0),
                listHeight = mutableListOf(Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0)
                    ,Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0))
            )
        }
        else {
            val newIndex = StatisticViewModel.statisticState.index
            newIndex.value += 1
            StatisticViewModel.statisticState = StatisticViewModel.statisticState.copy(
                index = newIndex,
                listHeight = mutableListOf(Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0)
                    ,Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0))
            )
        }
        StatisticViewModel(StaticDate).date.isUsedStatistic.value = true
        StatisticViewModel(StaticDate).date.isUsedTransactions.value = true
    }
}