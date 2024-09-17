package presentation.menu_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.screen.MenuScreen
import org.example.project.presentation.wallets_feature.detail_wallet_feature.screen.DetailWalletsScreen
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.DetailWalletViewModel

object AddMoneyIntent {
    fun execute(){
        StaticDate.navigator.push(DetailWalletsScreen)

        DetailWalletViewModel(StaticDate).date.isUsedAddSumMenu.value = true

    }
}