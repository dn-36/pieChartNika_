package org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class FillingNameState(
    val toast:MutableState<Boolean> = mutableStateOf(false)
)
