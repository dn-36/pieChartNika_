package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.edit_wallet_feature.screen.EditWalletScreen
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.EditWalletViewModel
import org.example.project.presentation.wallets_feature.list_wallets_feature.screen.ListWalletsScreen

object EditWalletIntent {
    fun execute(){
        EditWalletViewModel(StaticDate).date.isUsedEditWallet.value = true
        StaticDate.navigator.push(EditWalletScreen)
    }
}