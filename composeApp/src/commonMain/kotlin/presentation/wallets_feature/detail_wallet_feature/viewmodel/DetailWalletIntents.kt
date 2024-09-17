package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel

sealed class DetailWalletIntents {
    object Edit:DetailWalletIntents()
    object Subtract:DetailWalletIntents()
    object Add:DetailWalletIntents()
    object Back:DetailWalletIntents()
    object SetScreen:DetailWalletIntents()
    data class Done(val sum:String):DetailWalletIntents()
}