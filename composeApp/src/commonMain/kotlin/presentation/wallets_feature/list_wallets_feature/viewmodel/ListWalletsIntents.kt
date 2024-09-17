package org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel

sealed class ListWalletsIntents {
    object AddNewWallet:ListWalletsIntents()
    object SetScreen:ListWalletsIntents()
    data class DetailWallet(val index:Int):ListWalletsIntents()
    data class DeleteWallet(val index:Int):ListWalletsIntents()
    data class ChoosingMainWallet(val index:Int):ListWalletsIntents()
}