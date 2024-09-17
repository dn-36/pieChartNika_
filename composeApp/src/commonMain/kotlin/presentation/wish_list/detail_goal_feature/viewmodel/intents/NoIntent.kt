package org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.DetailGoalViewModel
import org.example.project.presentation.wish_list.wish_list_feature.screen.WishListScreen

object NoIntent {
    fun execute(){
        DetailGoalViewModel.detailGoalState = DetailGoalViewModel.detailGoalState.copy(
            alphaDelete = mutableStateOf(0f)
        )
    }
}