package org.example.project.presentation.menu_feature.viewmodel

sealed class MenuIntents {
    object AddTransaction:MenuIntents()
    object Income:MenuIntents()
    object Expense:MenuIntents()
    object PieChart:MenuIntents()
    object WishList:MenuIntents()
    object Calculator:MenuIntents()
    object Profile:MenuIntents()
    object Home:MenuIntents()
    object Statistic:MenuIntents()
    object Wallets:MenuIntents()
    object AddMoney:MenuIntents()
    data class ChoosingCalendar(val index:Int):MenuIntents()
}