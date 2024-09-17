package org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.intents

import database.goals_base.Goal
import database.wallets_base.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.utils.getCurrentMonth
import org.example.project.presentation.menu_feature.utils.getCurrentYear
import org.example.project.presentation.menu_feature.utils.getTodayDay
import org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel.AddNewWalletViewModel
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.FinishWishViewModel
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel
import org.example.project.presentation.wish_list.wish_list_feature.screen.WishListScreen
import org.example.project.utils.SumWallet
import org.example.project.utils.Wallets

object DoneIntent {
    fun execute(){
        FinishWishViewModel(StaticDate).date.listGoals.add(FinishWishViewModel.finishWishState.newGoal.value)

        val newGoal = FinishWishViewModel.finishWishState.newGoal.value

        CoroutineScope(Dispatchers.IO).launch {

                ServiceLocator.goalDao.upsert(
                    Goal(goal = newGoal))

        }

        TargetViewModel(StaticDate).date.isUsedWishList.value = true
        StaticDate.navigator.push(WishListScreen)
    }
}