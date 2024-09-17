package org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.intents

import androidx.compose.ui.graphics.Color
import org.example.project.presentation.add_transaction.utils.DataTransaction
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.ChoosingIconViewModel
import org.jetbrains.compose.resources.DrawableResource

object ChoosingIconIntent {
    fun execute(index:Int,image:DrawableResource){
        val newList = mutableListOf(
            Color.Transparent, Color.Transparent, Color.Transparent,
            Color.Transparent, Color.Transparent, Color.Transparent,
            Color.Transparent, Color.Transparent, Color.Transparent,
            Color.Transparent, Color.Transparent, Color.Transparent,)

        newList[index] = Color(0xFF027B5B)

        ChoosingIconViewModel.choosingIconState = ChoosingIconViewModel.choosingIconState.copy(
            listColorBorder = newList
        )
        DataTransaction.icon.value = "${index}"
    }
}