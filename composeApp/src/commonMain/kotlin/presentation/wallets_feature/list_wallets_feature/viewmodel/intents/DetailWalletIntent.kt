package org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.detail_wallet_feature.screen.DetailWalletsScreen
import org.example.project.presentation.wallets_feature.list_wallets_feature.screen.ListWalletsScreen
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsViewModel

object DetailWalletIntent {
    fun execute(index:Int){
        ListWalletsViewModel(StaticDate).date.indexDetailWallet.value = index
        StaticDate.navigator.push(DetailWalletsScreen)
    }
}