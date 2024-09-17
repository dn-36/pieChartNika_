package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents

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
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.DetailWalletViewModel
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.EditWalletViewModel
import org.example.project.utils.SumWallet

object DoneIntent {
    fun execute(sum:String){
        if(sum.length != 0) {
            var newSum = 0
            if (DetailWalletViewModel.detailWalletState.textAddOrSubtract.value == "Top up your balance") {
                newSum = DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(
                    StaticDate
                ).date.indexDetailWallet.value].sum.toInt()
                newSum += sum.toInt()

                DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].listTransactions.add(
                    SumWallet( type = "Add",date = "${getCurrentMonth()} ${getTodayDay()}, ${getCurrentYear()}",sum = "+${sum}")
                )

                val indexNow = EditWalletViewModel(StaticDate).date.indexDetailWallet.value+1
                val editedWallet = EditWalletViewModel(StaticDate).date.listWallets[EditWalletViewModel(StaticDate).date.indexDetailWallet.value]
                CoroutineScope(Dispatchers.IO).launch  {
                    ServiceLocator.peopleDao.update(Person( id = indexNow, wallet = editedWallet))
                }
                if(DetailWalletViewModel(StaticDate).date.isUsedAddSumMenu.value) {
                    DetailWalletViewModel(StaticDate).date.isUsedAddSumMenu.value = false
                    StaticDate.navigator.push(MenuScreen)

                }
            } else {
                newSum = DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(
                    StaticDate
                ).date.indexDetailWallet.value].sum.toInt()
                newSum -= sum.toInt()

                DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].listTransactions.add(
                    SumWallet(type = "Subtract",date = "${getCurrentMonth()} ${getTodayDay()}, ${getCurrentYear()}",sum = "-${sum}")
                )
            }
            DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].sum =
                newSum.toString()

            val indexNow = DetailWalletViewModel(StaticDate).date.indexDetailWallet.value+1
            val editedWallet = DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(StaticDate).date.indexDetailWallet.value]
            CoroutineScope(Dispatchers.IO).launch  {
                ServiceLocator.peopleDao.update(Person( id = indexNow, wallet = editedWallet))
            }
            DetailWalletViewModel.detailWalletState = DetailWalletViewModel.detailWalletState.copy(
                alpha = mutableStateOf(0f)
            )
        }
        else{
            DetailWalletViewModel.detailWalletState = DetailWalletViewModel.detailWalletState.copy(
                alpha = mutableStateOf(0f)
            )
        }
    }
}