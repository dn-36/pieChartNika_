package org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.intents

import ServiceLocator
import androidx.compose.runtime.mutableStateOf
import database.wallets_base.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.screen.MenuScreen
import org.example.project.presentation.menu_feature.utils.getCurrentMonth
import org.example.project.presentation.menu_feature.utils.getCurrentYear
import org.example.project.presentation.menu_feature.utils.getTodayDay
import org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.AddWalletViewModel
import org.example.project.utils.SumWallet
import org.example.project.utils.Wallets

object FinishIntent {
    fun execute(name:String,sum:String){
        if(name.length == 0 || sum.length == 0){
            AddWalletViewModel.addWalletState = AddWalletViewModel.addWalletState.copy(
                toast = mutableStateOf(true)
            )
        }
        else {

            AddWalletViewModel(StaticDate).date.listWallets.add(Wallets(sum = sum,name = name, currency = AddWalletViewModel.addWalletState.currency.value,
            listTransactionsIncome = mutableListOf()
                , listTransactionsExpense = mutableListOf(),mutableListOf(SumWallet(
                    type = "Add", date = "${getCurrentMonth()} ${getTodayDay()}, ${getCurrentYear()}",sum = "+${sum}"))
            ))

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    StaticDate.listWallets.forEach {
                        ServiceLocator.peopleDao.upsert(Person(wallet = it))
                        println("${it}")
                    }
                } catch (e: Exception) {
                    println("h \n d \n h \n" +
                            " d")
                    println("RoomError Error saving to database")
                    println("h \n d \n h \n" +
                            " d")
                }
            }

            StaticDate.navigator.push(MenuScreen)
        }
    }
}