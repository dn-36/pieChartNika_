package org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class ChoosingIconState(
    var listColorBorder:MutableList<Color> = mutableListOf(Color.Transparent,Color.Transparent,Color.Transparent,
        Color.Transparent,Color.Transparent,Color.Transparent,
        Color.Transparent,Color.Transparent,Color.Transparent,
        Color.Transparent,Color.Transparent,Color.Transparent,),
    var toast: MutableState<Boolean> = mutableStateOf(false)

)
