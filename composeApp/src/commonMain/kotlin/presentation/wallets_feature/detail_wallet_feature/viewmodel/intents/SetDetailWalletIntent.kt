package org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.DetailWalletViewModel

object SetDetailWalletIntent {
    fun execute(){
        DetailWalletViewModel.detailWalletState = DetailWalletViewModel.detailWalletState.copy(
            listTransactions = DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].listTransactions,
            nameWallet = mutableStateOf( DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].name)

        )
        if(DetailWalletViewModel(StaticDate).date.isUsedAddSumMenu.value){
            DetailWalletViewModel.detailWalletState = DetailWalletViewModel.detailWalletState.copy(
                textAddOrSubtract = mutableStateOf("Top up your balance"),
                alpha = mutableStateOf(1f)
            )
        }
    }
}