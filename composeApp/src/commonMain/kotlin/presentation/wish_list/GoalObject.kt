package org.example.project.presentation.wish_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object GoalObject {
    var target:MutableState<String> = mutableStateOf("")
    var sum:MutableState<Int> = mutableStateOf(0)
    var already:MutableState<Int> = mutableStateOf(0)
}