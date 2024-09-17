package org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.IncomeOrExpenseViewModel

object ChoosingIncomeIntent {
    fun execute(){
        if(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGrayIncome.value == 1f){
            IncomeOrExpenseViewModel.incomeOrExpenseState = IncomeOrExpenseViewModel.incomeOrExpenseState.copy(
                alphaGrayIncome = mutableStateOf(0f),
                alphaGreenIncome = mutableStateOf(1f),
                alphaGrayExpense = mutableStateOf(1f),
                alphaGreenExpense = mutableStateOf(0f)
            )
            //DataTransaction.incomeOrExpense.value = "Income"
        }
        else{
            IncomeOrExpenseViewModel.incomeOrExpenseState = IncomeOrExpenseViewModel.incomeOrExpenseState.copy(
                alphaGrayIncome = mutableStateOf(1f),
                alphaGreenIncome = mutableStateOf(0f),
                alphaGrayExpense = mutableStateOf(0f),
                alphaGreenExpense = mutableStateOf(1f)
            )
           // DataTransaction.incomeOrExpense.value = "Expense"
        }
    }
}