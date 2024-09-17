package org.example.project.presentation.wish_list.amount_savings_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class AmountSavingsState(
    var toast: MutableState<Boolean> = mutableStateOf(false)

)
