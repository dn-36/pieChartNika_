package org.example.project.presentation.statistic_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel
import org.example.project.utils.Transaction

object SetTransactionsIntent {
    fun execute() {
        if (StatisticViewModel(StaticDate).date.isUsedTransactions.value) {
            if (StatisticViewModel.statisticState.transactions.value == 1F) {
                val listTransaction = StatisticViewModel(StaticDate).date.listWallets[StatisticViewModel(StaticDate).date.indexWalletNow.value].listTransactionsIncome +
                        StatisticViewModel(StaticDate).date.listWallets[StatisticViewModel(StaticDate).date.indexWalletNow.value].listTransactionsExpense
                val newListTransaction = mutableListOf<Transaction>()
                for (n in listTransaction) {
                 if(n.month == StatisticViewModel.statisticState.listMonths[StatisticViewModel.statisticState.index.value]) {
                 newListTransaction.add(n)
                 }
                }
                StatisticViewModel.statisticState = StatisticViewModel.statisticState.copy(
                    listTransactions = newListTransaction
                )
                StatisticViewModel(StaticDate).date.isUsedTransactions.value = false
            }
        }
    }
}