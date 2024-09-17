package org.example.project.presentation.add_transaction.finish_fetaure.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import org.example.project.utils.Transaction
import org.jetbrains.compose.resources.DrawableResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.circle

data class FinishState(
    var transaction:MutableState<Transaction> = mutableStateOf(Transaction(img = "",
        category = "",name = "",month = "" ,day = "" , year = "", sum = "" , sign = "")),
    val img:MutableState<DrawableResource> = mutableStateOf(Res.drawable.circle),
    val color:MutableState<Color> = mutableStateOf(Color.Red),
)
