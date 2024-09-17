package org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class AddOrDeleteState(
    var toast: MutableState<Boolean> = mutableStateOf(false),
    var toastText: MutableState<String> = mutableStateOf("Fill in the field"),
    val alphaAdd:MutableState<Float> = mutableStateOf(1f),
    val alphaDelete:MutableState<Float> = mutableStateOf(0f),
)
