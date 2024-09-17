package org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents

import androidx.compose.ui.graphics.Color
import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsViewModel

object SetListWalletIntent {
    fun execute(){
        if(ListWalletsViewModel(StaticDate).date.isUsedListWallet.value) {
            ListWalletsViewModel(StaticDate).date.isUsedListWallet.value = false
            var newList = MutableList(ListWalletsViewModel(StaticDate).date.listWallets.size) {
                Color(0xFFC0C4C3)
            }
            newList[ListWalletsViewModel(StaticDate).date.indexWalletNow.value] = Color(0xFF027B5B)
            ListWalletsViewModel.listWalletsState = ListWalletsViewModel.listWalletsState.copy(
                listColor = newList,
                listWallets = ListWalletsViewModel(StaticDate).date.listWallets
            )
        }
    }
}