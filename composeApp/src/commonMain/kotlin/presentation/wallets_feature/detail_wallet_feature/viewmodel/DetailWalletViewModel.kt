package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents.AddIntent
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents.EditWalletIntent
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents.DoneIntent
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents.SetDetailWalletIntent
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents.SubtractIntent

class DetailWalletViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var detailWalletState by mutableStateOf(DetailWalletState())
    }
    fun processIntent(intents: DetailWalletIntents){
        when(intents){
            is DetailWalletIntents.Edit -> {EditWalletIntent.execute()}
            is DetailWalletIntents.Back -> {BackIntent.execute()}
            is DetailWalletIntents.Subtract -> {SubtractIntent.execute()}
            is DetailWalletIntents.Add -> {AddIntent.execute()}
            is DetailWalletIntents.SetScreen -> {SetDetailWalletIntent.execute()}
            is DetailWalletIntents.Done -> {DoneIntent.execute(intents.sum)}
        }
    }
}