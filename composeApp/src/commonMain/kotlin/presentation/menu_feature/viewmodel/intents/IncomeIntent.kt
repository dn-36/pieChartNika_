package org.example.project.presentation.menu_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel

object IncomeIntent {
    fun execute(){
        MenuViewModel.menuState = MenuViewModel.menuState.copy(
            alphaIncome = mutableStateOf(1f),
            alphaExpense = mutableStateOf(0f)
        )
    }
}