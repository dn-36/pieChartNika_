package org.example.project.presentation.wish_list.target_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class TargetState(
    var toast:MutableState<Boolean> = mutableStateOf(false)
)
