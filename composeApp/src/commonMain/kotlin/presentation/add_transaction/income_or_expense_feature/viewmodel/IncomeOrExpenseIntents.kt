package org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel

sealed class IncomeOrExpenseIntents {
    object ChoosingExpense:IncomeOrExpenseIntents()
    object ChoosingIncome:IncomeOrExpenseIntents()
    object Back:IncomeOrExpenseIntents()
    object Next:IncomeOrExpenseIntents()
}