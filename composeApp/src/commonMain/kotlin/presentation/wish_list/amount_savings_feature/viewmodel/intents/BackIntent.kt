package org.example.project.presentation.wish_list.amount_savings_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.target_feature.screen.TargetScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(TargetScreen)
    }
}