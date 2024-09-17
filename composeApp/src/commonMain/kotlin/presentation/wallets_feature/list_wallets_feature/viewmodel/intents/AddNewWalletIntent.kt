package org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.add_new_wallet_feature.screen.AddNewWalletScreen
import org.example.project.presentation.wallets_feature.list_wallets_feature.screen.ListWalletsScreen

object AddNewWalletIntent {
    fun execute(){
        StaticDate.navigator.push(AddNewWalletScreen)
    }
}