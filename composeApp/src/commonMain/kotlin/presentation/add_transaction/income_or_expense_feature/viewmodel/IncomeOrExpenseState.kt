package org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class IncomeOrExpenseState(
    var alphaGreenIncome:MutableState<Float> = mutableStateOf(1f),
    var alphaGrayIncome:MutableState<Float> = mutableStateOf(0f),
    var alphaGreenExpense:MutableState<Float> = mutableStateOf(0f),
    var alphaGrayExpense:MutableState<Float> = mutableStateOf(1f),
)
