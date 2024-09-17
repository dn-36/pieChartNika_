package org.example.project.presentation.wish_list.wish_list_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.target_feature.screen.TargetScreen

object AddGoalsIntent {
    fun execute(){
        StaticDate.navigator.push(TargetScreen)
    }
}