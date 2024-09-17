package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.example.project.utils.SumWallet

data class DetailWalletState(
    var textAddOrSubtract:MutableState<String> = mutableStateOf("Top up your balance"),
    var alpha:MutableState<Float> = mutableStateOf(0f),
    var listTransactions:MutableList<SumWallet> = mutableListOf(),
    var nameWallet:MutableState<String> = mutableStateOf("")
)
