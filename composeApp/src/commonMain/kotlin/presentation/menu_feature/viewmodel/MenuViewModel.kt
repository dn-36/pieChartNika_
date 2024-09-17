package org.example.project.presentation.menu_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.menu_feature.viewmodel.intents.AddTransactionIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.CalculatorIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.ChoosingCalendarIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.ExpenseIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.HomeIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.IncomeIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.PieChartIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.ProfileIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.StatisticIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.WalletsIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.WishListIntent
import presentation.menu_feature.viewmodel.intents.AddMoneyIntent

class MenuViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var menuState by mutableStateOf(MenuState())
    }
    fun processIntent(intents: MenuIntents){
        when(intents){
            is MenuIntents.AddTransaction -> { AddTransactionIntent.execute()}
            is MenuIntents.Income -> { IncomeIntent.execute()}
            is MenuIntents.WishList -> { WishListIntent.execute()}
            is MenuIntents.Calculator -> { CalculatorIntent.execute()}
            is MenuIntents.PieChart -> { PieChartIntent.execute()}
            is MenuIntents.Expense -> { ExpenseIntent.execute()}
            is MenuIntents.Profile -> { ProfileIntent.execute()}
            is MenuIntents.Statistic -> { StatisticIntent.execute()}
            is MenuIntents.Home -> { HomeIntent.execute()}
            is MenuIntents.Wallets -> { WalletsIntent.execute()}
            is MenuIntents.AddMoney -> { AddMoneyIntent.execute()}
            is MenuIntents.ChoosingCalendar -> {ChoosingCalendarIntent.execute(intents.index)}
        }
    }
}