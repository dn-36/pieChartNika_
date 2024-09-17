package org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel.intents.ChoosingCurrencyIntent
import org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel.intents.DoneIntent

class AddNewWalletViewModel(val date: StaticDateApi): ViewModel() {
    companion object {
        var addNewWalletState by mutableStateOf(AddNewWalletState())
    }
    fun processIntent(intents: AddNewWalletIntents){
        when(intents){
            is AddNewWalletIntents.Done -> {DoneIntent.execute(intents.name,intents.sum)}
            is AddNewWalletIntents.ChoosingCurrency -> {ChoosingCurrencyIntent.execute(intents.index,intents.currency)}
            is AddNewWalletIntents.Back -> {BackIntent.execute()}
        }
    }
}