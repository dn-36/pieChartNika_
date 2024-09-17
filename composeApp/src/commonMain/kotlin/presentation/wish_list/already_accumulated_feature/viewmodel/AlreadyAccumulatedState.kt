package org.example.project.presentation.wish_list.already_accumulated_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class AlreadyAccumulatedState(
    var toast: MutableState<Boolean> = mutableStateOf(false),
    var textToast: MutableState<String> = mutableStateOf("")

)
