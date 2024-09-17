package org.example.project.presentation.registerAndStart.gender_feature.viewmodel.intents

import androidx.compose.ui.graphics.Color
import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.add_wallet_feature.screen.AddWalletScreen
import org.example.project.presentation.registerAndStart.gender_feature.viewmodel.GenderViewModel
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.man_ava
import room_cmp.composeapp.generated.resources.woman_ava

object NextIntent {
    fun execute(){
        StaticDate.navigator.push(AddWalletScreen)
        if(GenderViewModel.genderState.colorMan.value == Color(0xFFF8DB1C)){
            GenderViewModel(StaticDate).date.gender = Res.drawable.man_ava
        }
        else if(GenderViewModel.genderState.colorWoman.value == Color(0xFFF8DB1C)){
            GenderViewModel(StaticDate).date.gender = Res.drawable.woman_ava
        }
    }
}