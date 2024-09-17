package org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel

import org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.AddWalletIntents
import org.jetbrains.compose.resources.DrawableResource

sealed class AddNewWalletIntents {
    data class ChoosingCurrency(val index:Int,val currency: DrawableResource): AddNewWalletIntents()
    data class Done(val name:String,val sum:String): AddNewWalletIntents()
    object Back:AddNewWalletIntents()
}