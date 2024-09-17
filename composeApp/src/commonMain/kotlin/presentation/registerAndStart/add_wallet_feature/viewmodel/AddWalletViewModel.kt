package org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.intents.ChoosingCurrencyIntent
import org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.intents.FinishIntent

class AddWalletViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var addWalletState by mutableStateOf(AddWalletState())
    }
    fun processIntent(intents: AddWalletIntents){
        when(intents){
            is AddWalletIntents.ChoosingCurrency -> {ChoosingCurrencyIntent.execute(intents.index,intents.currency)}
            is AddWalletIntents.Finish -> {FinishIntent.execute(intents.name,intents.sum)}
            is AddWalletIntents.Back -> {BackIntent.execute()}
        }
    }
}