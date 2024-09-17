package org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.choosing_category_feature.screen.ChoosingCategoryScreen
import org.example.project.presentation.add_transaction.income_or_expense_feature.screen.IncomeOrExpenseScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(ChoosingCategoryScreen)
    }
}