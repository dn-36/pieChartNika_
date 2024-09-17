package org.example.project.presentation.add_transaction.date_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class DateState(
    var alphaMonth:MutableState<Float> = mutableStateOf(0f),
    var alphaDay:MutableState<Float> = mutableStateOf(0f),
    var alphaYear:MutableState<Float> = mutableStateOf(0f),
    var alphaTextMonth:MutableState<Float> = mutableStateOf(1f),
    var alphaTextDay:MutableState<Float> = mutableStateOf(1f),
    var alphaTextYear:MutableState<Float> = mutableStateOf(1f),
    var textMonth:MutableState<String> = mutableStateOf("September"),
    var textDay:MutableState<String> = mutableStateOf("1"),
    var textYear:MutableState<String> = mutableStateOf("2024"),
    var rotateMonth:MutableState<Float> = mutableStateOf(270F),
    var rotateDay:MutableState<Float> = mutableStateOf(270F),
    var rotateYear:MutableState<Float> = mutableStateOf(270F),
)
