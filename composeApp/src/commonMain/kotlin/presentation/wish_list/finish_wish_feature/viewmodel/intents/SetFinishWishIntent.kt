package org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.utils.getTodayDay
import org.example.project.presentation.wish_list.GoalObject
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.FinishWishViewModel
import org.example.project.utils.Goal
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.bank_of_money

object SetFinishWishIntent {
    fun execute(){
        if(FinishWishViewModel(StaticDate).date.isUsedFinishWish.value) {
            FinishWishViewModel(StaticDate).date.isUsedFinishWish.value = false
            FinishWishViewModel.finishWishState = FinishWishViewModel.finishWishState.copy(
                newGoal = mutableStateOf(
                    Goal(
                        target = GoalObject.target.value,
                        sum = GoalObject.sum.value,
                        already = GoalObject.already.value,
                        transactions = 1,
                        date = getTodayDay()
                    )
                )
            )
        }
    }
}