package org.example.project.presentation.menu_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel
import org.example.project.presentation.statistic_feature.screen.StatisticScreen
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.FinishWishViewModel
import org.example.project.presentation.wish_list.wish_list_feature.screen.WishListScreen

object StatisticIntent {
    fun execute(){
        MenuViewModel(StaticDate).date.isUsedStatistic.value = true
        MenuViewModel(StaticDate).date.isUsedTransactions.value = true
        StaticDate.navigator.push(StatisticScreen)
    }
}