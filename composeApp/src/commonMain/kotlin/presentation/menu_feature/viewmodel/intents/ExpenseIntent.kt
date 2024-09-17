package org.example.project.presentation.menu_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel

object ExpenseIntent {
    fun execute(){
        MenuViewModel.menuState = MenuViewModel.menuState.copy(
            alphaExpense = mutableStateOf(1f),
            alphaIncome = mutableStateOf(0f)
        )
    }
}