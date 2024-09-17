package org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import database.wallets_base.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.detail_wallet_feature.screen.DetailWalletsScreen
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.EditWalletViewModel


object DoneIntent {
    fun execute(name:String){
        if(name.length == 0){
            EditWalletViewModel.editWalletState = EditWalletViewModel.editWalletState.copy(
                toast = mutableStateOf(true)
            )
        }
        else {
            EditWalletViewModel(StaticDate).date.listWallets[EditWalletViewModel(StaticDate).date.indexDetailWallet.value].name = name
            EditWalletViewModel(StaticDate).date.listWallets[EditWalletViewModel(StaticDate).date.indexDetailWallet.value].currency = EditWalletViewModel.editWalletState.currency.value


            val indexNow = EditWalletViewModel(StaticDate).date.indexDetailWallet.value+1
            val editedWallet = EditWalletViewModel(StaticDate).date.listWallets[EditWalletViewModel(StaticDate).date.indexDetailWallet.value]
            CoroutineScope(Dispatchers.IO).launch  {
                ServiceLocator.peopleDao.update(Person( id = indexNow, wallet = editedWallet))
            }
            StaticDate.navigator.push(DetailWalletsScreen)
        }
    }
}