package org.example.project.presentation.wish_list.finish_wish_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.example.project.utils.Goal
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.bank_of_money

data class FinishWishState (
    var newGoal: MutableState<Goal> = mutableStateOf(Goal(
        target = "",sum = 0 , already = 0, transactions = 1, date = 0))
)