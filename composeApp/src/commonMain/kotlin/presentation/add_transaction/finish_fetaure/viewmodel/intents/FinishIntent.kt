package org.example.project.presentation.add_transaction.finish_fetaure.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.utils.DataTransaction
import org.example.project.presentation.add_transaction.finish_fetaure.viewmodel.FinishViewModel
import org.example.project.presentation.menu_feature.screen.MenuScreen
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.circle

object FinishIntent {
    fun execute(){
        if (DataTransaction.incomeOrExpense.value == "Expense"){
            FinishViewModel(StaticDate).date.listWallets[FinishViewModel(StaticDate).date.indexWalletNow.value].listTransactionsExpense.add(
                FinishViewModel.finishState.transaction.value
            )
           /* FinishViewModel(StaticDate).date.listTransactionsExpense.add(
                FinishViewModel.finishState.transaction.value
            )*/
        }
        else if(DataTransaction.incomeOrExpense.value == "Income"){
            FinishViewModel(StaticDate).date.listWallets[FinishViewModel(StaticDate).date.indexWalletNow.value].listTransactionsIncome.add(
                FinishViewModel.finishState.transaction.value
            )
        }
         DataTransaction.incomeOrExpense.value = ""
         DataTransaction.sum.value = ""
         DataTransaction.category.value = ""
         DataTransaction.name.value = ""
         DataTransaction.month.value = ""
         DataTransaction.day.value = ""
         DataTransaction.year.value = ""
         DataTransaction.icon.value = ""

        StaticDate.navigator.push(MenuScreen)
    }
}