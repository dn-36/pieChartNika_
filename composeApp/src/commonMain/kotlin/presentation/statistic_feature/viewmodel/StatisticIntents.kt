package org.example.project.presentation.statistic_feature.viewmodel

sealed class StatisticIntents {
    object SetDiagram:StatisticIntents()
    object SetTransactions:StatisticIntents()
    object Diagram:StatisticIntents()
    object MoneyBox:StatisticIntents()
    object Transaction:StatisticIntents()
    object PlusIndexMonth:StatisticIntents()
    object MinusIndexMonth:StatisticIntents()
}