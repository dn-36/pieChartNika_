package org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel

import org.jetbrains.compose.resources.DrawableResource

sealed class AddWalletIntents {
    data class ChoosingCurrency(val index:Int,val currency:DrawableResource):AddWalletIntents()
    data class Finish(val name:String,val sum:String):AddWalletIntents()
    object Back:AddWalletIntents()
}