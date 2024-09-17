package org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.intents.ChoosingCurrencyIntent
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.intents.DoneIntent
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.intents.SetEditWalletIntent

class EditWalletViewModel(val date: StaticDateApi): ViewModel() {
companion object{
    var editWalletState by mutableStateOf(EditWalletState())
}
    fun processIntent(intents: EditWalletIntents){
        when(intents){
            is EditWalletIntents.Done -> {DoneIntent.execute(intents.name)}
            is EditWalletIntents.Back -> {BackIntent.execute()}
            is EditWalletIntents.SetScreen -> {SetEditWalletIntent.execute()}
            is EditWalletIntents.ChoosingCurrency -> {ChoosingCurrencyIntent.execute(intents.index,intents.currency)}
        }
    }
}