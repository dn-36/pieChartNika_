package org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class ChoosingCategoryState(
    var listColors:MutableList<Color> = mutableListOf(Color(0xFFD8D8D8),Color(0xFFD8D8D8),Color(0xFFD8D8D8),
        Color(0xFFD8D8D8),Color(0xFFD8D8D8),Color(0xFFD8D8D8),
        Color(0xFFD8D8D8),Color(0xFFD8D8D8),Color(0xFFD8D8D8),
        Color(0xFFD8D8D8),Color(0xFFD8D8D8),Color(0xFFD8D8D8)),
    var toast: MutableState<Boolean> = mutableStateOf(false)

)
