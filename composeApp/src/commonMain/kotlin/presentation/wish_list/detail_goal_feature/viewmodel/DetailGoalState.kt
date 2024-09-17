package org.example.project.presentation.wish_list.detail_goal_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class DetailGoalState(
    var alphaDelete:MutableState<Float> = mutableStateOf(0f))
