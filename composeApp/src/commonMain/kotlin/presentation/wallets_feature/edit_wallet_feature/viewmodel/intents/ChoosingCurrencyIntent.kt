package org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.AddWalletViewModel
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.EditWalletViewModel
import org.jetbrains.compose.resources.DrawableResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.circle
import room_cmp.composeapp.generated.resources.clicked_circle

object ChoosingCurrencyIntent {
    fun execute(index:Int,currency: DrawableResource){

        val newList = mutableListOf(
            Res.drawable.circle, Res.drawable.circle, Res.drawable.circle,
            Res.drawable.circle, Res.drawable.circle, Res.drawable.circle,
            Res.drawable.circle, Res.drawable.circle, Res.drawable.circle,)

        newList[index] = Res.drawable.clicked_circle

        EditWalletViewModel.editWalletState = EditWalletViewModel.editWalletState.copy(
            listCurrency = newList,
            currency = mutableStateOf("${index}")
        )
    }
}