package org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.ChoosingIconViewModel
import org.example.project.presentation.add_transaction.date_feature.screen.DateScreen
import org.example.project.presentation.add_transaction.utils.DataTransaction
import room_cmp.composeapp.generated.resources.circle
import room_cmp.composeapp.generated.resources.Res

object NextIntent {
    fun execute(){
        if(DataTransaction.icon.value != "") {
            StaticDate.navigator.push(DateScreen)
            val list = mutableListOf(
                Color.Transparent, Color.Transparent, Color.Transparent,
                Color.Transparent, Color.Transparent, Color.Transparent,
                Color.Transparent, Color.Transparent, Color.Transparent,
                Color.Transparent, Color.Transparent, Color.Transparent,
            )

            ChoosingIconViewModel.choosingIconState = ChoosingIconViewModel.choosingIconState.copy(
                listColorBorder = list
            )
        }
        else{
            ChoosingIconViewModel.choosingIconState = ChoosingIconViewModel.choosingIconState.copy(
                toast = mutableStateOf(true)
            )
        }
    }
}