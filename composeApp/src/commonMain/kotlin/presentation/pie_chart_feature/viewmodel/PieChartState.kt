package org.example.project.presentation.pie_chart_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class PieChartState(
    var percentIncome:MutableState<Float> = mutableStateOf(0f),
    var percentExpense:MutableState<Float> = mutableStateOf(0f),
    var alphaText:MutableState<Float> = mutableStateOf(0f),
)
