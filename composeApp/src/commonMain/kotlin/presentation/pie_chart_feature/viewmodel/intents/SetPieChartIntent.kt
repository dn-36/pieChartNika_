package org.example.project.presentation.pie_chart_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.utils.getCurrentMonth
import org.example.project.presentation.menu_feature.utils.getCurrentYear
import org.example.project.presentation.menu_feature.utils.getDaysOfCurrentWeek
import org.example.project.presentation.menu_feature.utils.getTodayDay
import org.example.project.presentation.pie_chart_feature.viewmodel.PieChartViewModel

object SetPieChartIntent {
    fun execute() {
        if (PieChartViewModel(StaticDate).date.isUsedPieChart.value) {
            PieChartViewModel(StaticDate).date.isUsedPieChart.value = false
            val totalTransactions = PieChartViewModel(StaticDate).date.listWallets[PieChartViewModel(StaticDate).date.indexWalletNow.value].listTransactionsIncome.size +
                    PieChartViewModel(StaticDate).date.listWallets[PieChartViewModel(StaticDate).date.indexWalletNow.value].listTransactionsExpense.size

// Если totalTransactions не равен 0, то считаем проценты для каждого списка
            if (totalTransactions > 0) {
                // Процент для доходов
                val incomePercent =
                    (PieChartViewModel(StaticDate).date.listWallets[PieChartViewModel(StaticDate).date.indexWalletNow.value].listTransactionsIncome.size.toFloat() / totalTransactions) * 100

                // Процент для расходов
                val expensePercent =
                    (PieChartViewModel(StaticDate).date.listWallets[PieChartViewModel(StaticDate).date.indexWalletNow.value].listTransactionsExpense.size.toFloat() / totalTransactions) * 100

                PieChartViewModel.pieChartState = PieChartViewModel.pieChartState.copy(
                    percentExpense = mutableStateOf(expensePercent.toFloat()),
                    percentIncome = mutableStateOf(incomePercent.toFloat()),
                    alphaText = mutableStateOf(0f)
                )
            } else {
                PieChartViewModel.pieChartState = PieChartViewModel.pieChartState.copy(
                    alphaText = mutableStateOf(1f)
                )
            }
        }
    }
}