package org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel

import org.jetbrains.compose.resources.DrawableResource

sealed class EditWalletIntents {
    object Back:EditWalletIntents()
    object SetScreen:EditWalletIntents()
    data class Done(val name:String):EditWalletIntents()
    data class ChoosingCurrency(val index:Int,val currency: DrawableResource):EditWalletIntents()
}