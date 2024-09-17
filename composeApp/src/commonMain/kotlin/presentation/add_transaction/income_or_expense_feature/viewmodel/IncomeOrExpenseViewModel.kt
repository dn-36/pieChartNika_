package org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.intents.NextIntent
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.intents.ChoosingExpenseIntent
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.intents.ChoosingIncomeIntent

class IncomeOrExpenseViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var incomeOrExpenseState by mutableStateOf(IncomeOrExpenseState())
    }
    fun processIntent(intents: IncomeOrExpenseIntents){
        when(intents){
            is IncomeOrExpenseIntents.ChoosingIncome -> {ChoosingIncomeIntent.execute()}
            is IncomeOrExpenseIntents.ChoosingExpense -> {ChoosingExpenseIntent.execute()}
            is IncomeOrExpenseIntents.Back -> {BackIntent.execute()}
            is IncomeOrExpenseIntents.Next -> {NextIntent.execute()}
        }
    }
}