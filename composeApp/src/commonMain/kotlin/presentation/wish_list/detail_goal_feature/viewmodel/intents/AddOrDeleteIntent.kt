package org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.screen.AddOrDeleteScreen

object AddOrDeleteIntent {
    fun execute(){
        StaticDate.navigator.push(AddOrDeleteScreen)
    }
}