package org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.screen.AddOrDeleteScreen
import org.example.project.presentation.wish_list.detail_goal_feature.screen.DetailGoalScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(DetailGoalScreen)
    }
}