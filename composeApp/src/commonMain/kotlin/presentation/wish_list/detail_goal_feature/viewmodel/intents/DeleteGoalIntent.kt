package org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.DetailGoalViewModel

object DeleteGoalIntent {
fun execute(){
    DetailGoalViewModel.detailGoalState = DetailGoalViewModel.detailGoalState.copy(
        alphaDelete = mutableStateOf(1f)
    )
}
}