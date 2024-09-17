package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.utils.getCurrentMonth
import org.example.project.presentation.menu_feature.utils.getCurrentYear
import org.example.project.presentation.menu_feature.utils.getTodayDay
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.DetailWalletViewModel
import org.example.project.utils.SumWallet


object AddIntent {
    fun execute(){

        DetailWalletViewModel.detailWalletState = DetailWalletViewModel.detailWalletState.copy(
            textAddOrSubtract = mutableStateOf("Top up your balance"),
            alpha = mutableStateOf(1f)
        )
    }
}