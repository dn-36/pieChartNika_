package org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.AddWalletViewModel
import org.jetbrains.compose.resources.DrawableResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.circle
import room_cmp.composeapp.generated.resources.clicked_circle

object ChoosingCurrencyIntent {
    fun execute(index:Int,currency:DrawableResource){

       var newList = mutableListOf(Res.drawable.circle,Res.drawable.circle,Res.drawable.circle,
            Res.drawable.circle,Res.drawable.circle,Res.drawable.circle,
            Res.drawable.circle,Res.drawable.circle,Res.drawable.circle,)

        newList[index] = Res.drawable.clicked_circle

        AddWalletViewModel.addWalletState = AddWalletViewModel.addWalletState.copy(
            listCurrency = newList,
            currency = mutableStateOf("${index}")
        )
    }
}