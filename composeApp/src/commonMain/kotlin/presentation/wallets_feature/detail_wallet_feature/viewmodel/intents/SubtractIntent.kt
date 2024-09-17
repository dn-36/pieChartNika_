package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.DetailWalletViewModel

object SubtractIntent {
    fun execute(){
        DetailWalletViewModel.detailWalletState = DetailWalletViewModel.detailWalletState.copy(
            textAddOrSubtract = mutableStateOf("Remove from balance"),
            alpha = mutableStateOf(1f)
        )
    }
}