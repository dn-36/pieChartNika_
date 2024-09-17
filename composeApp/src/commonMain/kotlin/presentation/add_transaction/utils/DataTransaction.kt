package org.example.project.presentation.add_transaction.utils

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.jetbrains.compose.resources.DrawableResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.circle

object DataTransaction {
    var category:MutableState<String> = mutableStateOf("")
    var sum:MutableState<String> = mutableStateOf("")
    var name:MutableState<String> = mutableStateOf("")
    var incomeOrExpense:MutableState<String> = mutableStateOf("")
    var month:MutableState<String> = mutableStateOf("")
    var day:MutableState<String> = mutableStateOf("")
    var year:MutableState<String> = mutableStateOf("")
    var icon:MutableState<String> = mutableStateOf("")
}