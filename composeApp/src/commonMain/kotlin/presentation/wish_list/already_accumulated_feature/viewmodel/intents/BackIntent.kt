package org.example.project.presentation.wish_list.already_accumulated_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.already_accumulated_feature.screen.AlreadyAccumulatedScreen
import org.example.project.presentation.wish_list.amount_savings_feature.screen.AmountSavingsScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(AmountSavingsScreen)
    }
}