package org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import org.example.project.core.StaticDate
import org.example.project.utils.Wallets

data class ListWalletsState(
    var listColor:MutableList<Color> = mutableListOf(Color(0xFFC0C4C3)),
    var listWallets:MutableList<Wallets> = mutableListOf(),
    var toast:MutableState<Boolean> = mutableStateOf(false)
)
