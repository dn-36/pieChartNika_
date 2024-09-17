package org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.ChoosingCategoryViewModel
import org.example.project.presentation.add_transaction.income_or_expense_feature.screen.IncomeOrExpenseScreen
import org.example.project.presentation.add_transaction.utils.DataTransaction
import org.example.project.presentation.menu_feature.screen.MenuScreen

object NextIntent {
    fun execute(){
        if(DataTransaction.category.value.length != 0) {
            StaticDate.navigator.push(IncomeOrExpenseScreen)

            val list = mutableListOf(
                Color(0xFFD8D8D8), Color(0xFFD8D8D8), Color(0xFFD8D8D8),
                Color(0xFFD8D8D8), Color(0xFFD8D8D8), Color(0xFFD8D8D8),
                Color(0xFFD8D8D8), Color(0xFFD8D8D8), Color(0xFFD8D8D8),
                Color(0xFFD8D8D8), Color(0xFFD8D8D8), Color(0xFFD8D8D8)
            )
            ChoosingCategoryViewModel.choosingCategoryState =
                ChoosingCategoryViewModel.choosingCategoryState.copy(
                    listColors = list
                )
        }
        else{
            ChoosingCategoryViewModel.choosingCategoryState =
                ChoosingCategoryViewModel.choosingCategoryState.copy(
                    toast = mutableStateOf(true)
                )
        }
    }
}