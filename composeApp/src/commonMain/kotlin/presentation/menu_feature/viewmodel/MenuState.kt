package org.example.project.presentation.menu_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class MenuState(
    val alphaIncome:MutableState<Float> = mutableStateOf(1f),
    val alphaExpense:MutableState<Float> = mutableStateOf(0f),
    val colorCalendar:MutableList<Color> = mutableListOf(Color(0xFFF0F2F6),Color.White,Color.White,Color.White),
)
