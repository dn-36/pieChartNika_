package org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.detail_wallet_feature.screen.DetailWalletsScreen
import org.example.project.presentation.wallets_feature.list_wallets_feature.screen.ListWalletsScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(DetailWalletsScreen)
    }
}