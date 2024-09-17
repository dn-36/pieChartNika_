package org.example.project.presentation.menu_feature.utils

import androidx.compose.ui.graphics.Color
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel
import org.example.project.utils.Transaction

    fun setTransactionList():MutableList<Transaction>{
        var list = mutableListOf<Transaction>()
        if(MenuViewModel.menuState.alphaIncome.value == 1f){
            list =  MenuViewModel(StaticDate).date.listWallets[MenuViewModel(StaticDate).date.indexWalletNow.value].listTransactionsIncome
        }
        else if(MenuViewModel.menuState.alphaExpense.value == 1f){
            list = MenuViewModel(StaticDate).date.listWallets[MenuViewModel(StaticDate).date.indexWalletNow.value].listTransactionsExpense
        }
        return list
    }

fun setTransaction():MutableList<Transaction>{
    main()
    val list = mutableListOf<Transaction>()

    if(MenuViewModel.menuState.colorCalendar[0] == Color(0xFFF0F2F6)) {
        for (i in setTransactionList()) {
                if (i.day == getTodayDay().toString() &&
                    i.month == getCurrentMonth() &&
                    i.year == getCurrentYear().toString()
                ) {
                    if (!list.contains(i)) {
                        list.add(i)
                    }
            }
        }
    }
    else if(MenuViewModel.menuState.colorCalendar[1] == Color(0xFFF0F2F6)){
        for (i in setTransactionList()) {
            for(n in getDaysOfCurrentWeek()){
            if (i.day == n.toString() &&
                i.month == getCurrentMonth() &&
                i.year == getCurrentYear().toString()
            ) {
                if (!list.contains(i)) {
                    list.add(i)
                }
            }
            }
        }
    }
        else if(MenuViewModel.menuState.colorCalendar[2] == Color(0xFFF0F2F6)){
        for (i in setTransactionList()) {
                if (i.month == getCurrentMonth() &&
                    i.year == getCurrentYear().toString()
                ) {
                    if (!list.contains(i)) {
                        list.add(i)
                    }
            }
        }
    }
    else if(MenuViewModel.menuState.colorCalendar[3] == Color(0xFFF0F2F6)){
        for (i in setTransactionList()) {
                if (i.year == getCurrentYear().toString()) {
                    if (!list.contains(i)) {
                        list.add(i)
                    }
            }
        }
    }
    return list
}
