package org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents

import database.goals_base.Goal
import database.wallets_base.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsViewModel
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.DetailGoalViewModel
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel
import org.example.project.presentation.wish_list.wish_list_feature.screen.WishListScreen

object YesIntent {
    fun execute(){
        val deletedGoal = DetailGoalViewModel(StaticDate).date.listGoals[DetailGoalViewModel(StaticDate).date.goalNow.value]
        val index = DetailGoalViewModel(StaticDate).date.goalNow.value + 1

        CoroutineScope(Dispatchers.IO).launch  {
            ServiceLocator.goalDao.delete(Goal(id = index,goal = deletedGoal))
        }
        DetailGoalViewModel(StaticDate).date.listGoals.removeAt(DetailGoalViewModel(StaticDate).date.goalNow.value)
        TargetViewModel(StaticDate).date.isUsedWishList.value = true
        StaticDate.navigator.push(WishListScreen)
    }
}