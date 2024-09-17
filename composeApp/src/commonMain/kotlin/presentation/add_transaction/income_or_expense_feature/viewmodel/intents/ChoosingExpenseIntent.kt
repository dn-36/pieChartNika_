package org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.IncomeOrExpenseViewModel

object ChoosingExpenseIntent {
    fun execute(){
        if(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGrayExpense.value == 1f){
            IncomeOrExpenseViewModel.incomeOrExpenseState = IncomeOrExpenseViewModel.incomeOrExpenseState.copy(
                alphaGrayExpense = mutableStateOf(0f),
                alphaGreenExpense = mutableStateOf(1f),
                alphaGreenIncome = mutableStateOf(0f),
                alphaGrayIncome = mutableStateOf(1f)
            )
            //DataTransaction.incomeOrExpense.value = "Expense"
        }
        else{
            IncomeOrExpenseViewModel.incomeOrExpenseState = IncomeOrExpenseViewModel.incomeOrExpenseState.copy(
                alphaGrayExpense = mutableStateOf(1f),
                alphaGreenExpense = mutableStateOf(0f),
                alphaGreenIncome = mutableStateOf(1f),
                alphaGrayIncome = mutableStateOf(0f)
            )
           // DataTransaction.incomeOrExpense.value = "Income"
        }
    }
}