package org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.jetbrains.compose.resources.DrawableResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.circle
import room_cmp.composeapp.generated.resources.one_currency

data class EditWalletState(
    var listCurrency:MutableList<DrawableResource> = mutableListOf(
        Res.drawable.circle, Res.drawable.circle,
        Res.drawable.circle, Res.drawable.circle, Res.drawable.circle, Res.drawable.circle,
        Res.drawable.circle, Res.drawable.circle, Res.drawable.circle,),
    val toast: MutableState<Boolean> = mutableStateOf(false),
    val currency: MutableState<String> = mutableStateOf(""),
)
