package org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.utils.DataTransaction
import org.example.project.presentation.add_transaction.choosing_icon_feature.screen.ChoosingIconScreen
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.IncomeOrExpenseViewModel

object NextIntent {
    fun execute(){
        if(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGreenIncome.value == 1f) {
            DataTransaction.incomeOrExpense.value = "Income"
        }
        else if(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGreenExpense.value == 1f){
            DataTransaction.incomeOrExpense.value = "Expense"
        }
        StaticDate.navigator.push(ChoosingIconScreen)

    }
}