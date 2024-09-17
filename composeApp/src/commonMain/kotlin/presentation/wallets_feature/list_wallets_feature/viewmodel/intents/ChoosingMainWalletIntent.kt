package org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents

import androidx.compose.ui.graphics.Color
import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsViewModel

object ChoosingMainWalletIntent {
    fun execute(index:Int){
        val newList = MutableList(ListWalletsViewModel(StaticDate).date.listWallets.size){ Color(0xFFC0C4C3) }
        newList[index] = Color(0xFF027B5B)
     ListWalletsViewModel.listWalletsState = ListWalletsViewModel.listWalletsState.copy(
         listColor = newList
     )
        ListWalletsViewModel(StaticDate).date.indexWalletNow.value = index
    }
}