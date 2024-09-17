package org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents.AddNewWalletIntent
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents.ChoosingMainWalletIntent
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents.DeleteWalletIntent
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents.DetailWalletIntent
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents.SetListWalletIntent

class ListWalletsViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var listWalletsState by mutableStateOf(ListWalletsState())
    }
    fun processIntent(intents: ListWalletsIntents){
        when(intents){
            is ListWalletsIntents.AddNewWallet -> {AddNewWalletIntent.execute()}
            is ListWalletsIntents.SetScreen -> {SetListWalletIntent.execute()}
            is ListWalletsIntents.DetailWallet -> {DetailWalletIntent.execute(intents.index)}
            is ListWalletsIntents.DeleteWallet -> {DeleteWalletIntent.execute(intents.index)}
            is ListWalletsIntents.ChoosingMainWallet -> {ChoosingMainWalletIntent.execute(intents.index)}
        }
    }
}