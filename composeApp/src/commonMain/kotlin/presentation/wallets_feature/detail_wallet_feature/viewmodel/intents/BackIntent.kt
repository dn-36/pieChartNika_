package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.gender_feature.screen.GenderScreen
import org.example.project.presentation.wallets_feature.list_wallets_feature.screen.ListWalletsScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(ListWalletsScreen)
    }
}