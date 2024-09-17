package org.example.project.presentation.menu_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel
import org.example.project.presentation.wallets_feature.list_wallets_feature.screen.ListWalletsScreen
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsViewModel

object WalletsIntent {
    fun execute(){
        MenuViewModel(StaticDate).date.isUsedListWallet.value = true
        StaticDate.navigator.push(ListWalletsScreen)
    }
}