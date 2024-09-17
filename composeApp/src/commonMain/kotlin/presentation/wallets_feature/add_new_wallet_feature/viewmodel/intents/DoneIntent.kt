package org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import database.wallets_base.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.utils.getCurrentMonth
import org.example.project.presentation.menu_feature.utils.getCurrentYear
import org.example.project.presentation.menu_feature.utils.getTodayDay
import org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel.AddNewWalletViewModel
import org.example.project.presentation.wallets_feature.list_wallets_feature.screen.ListWalletsScreen
import org.example.project.utils.SumWallet
import org.example.project.utils.Wallets

object DoneIntent {
    fun execute(name:String,sum:String){
        if(name.length == 0 || sum.length == 0){
            AddNewWalletViewModel.addNewWalletState = AddNewWalletViewModel.addNewWalletState.copy(
                toast = mutableStateOf(true)
            )
        }
        else {
            AddNewWalletViewModel(StaticDate).date.listWallets.add(
                Wallets(sum = sum,name = name,
                currency = AddNewWalletViewModel.addNewWalletState.currency.value, listTransactionsIncome = mutableListOf()
                , listTransactionsExpense = mutableListOf(),mutableListOf(
                        SumWallet(
                            type = "Add", date = "${getCurrentMonth()} ${getTodayDay()}, ${getCurrentYear()}",sum = "+${sum}")
                    )
            )
            )
            CoroutineScope(Dispatchers.IO).launch {
                try {
                        ServiceLocator.peopleDao.upsert(
                            Person(wallet = Wallets(sum = sum,name = name,
                            currency = AddNewWalletViewModel.addNewWalletState.currency.value, listTransactionsIncome = mutableListOf()
                            , listTransactionsExpense = mutableListOf(),mutableListOf(
                                SumWallet(
                                    type = "Add", date = "${getCurrentMonth()} ${getTodayDay()}, ${getCurrentYear()}",sum = "+${sum}")
                            )
                        ))
                        )
                } catch (e: Exception) {
                    println("h \n d \n h \n" +
                            " d")
                    println("RoomError Error saving to database")
                    println("h \n d \n h \n" +
                            " d")
                }
            }

            AddNewWalletViewModel(StaticDate).date.isUsedListWallet.value = true
            StaticDate.navigator.push(ListWalletsScreen)
        }
    }
}