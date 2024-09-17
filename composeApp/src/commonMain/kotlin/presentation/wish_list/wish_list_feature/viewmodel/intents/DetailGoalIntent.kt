package org.example.project.presentation.wish_list.wish_list_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.detail_goal_feature.screen.DetailGoalScreen
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.WishListViewModel

object DetailGoalIntent {
    fun execute(index:Int){
        WishListViewModel(StaticDate).date.goalNow.value = index
        StaticDate.navigator.push(DetailGoalScreen)
    }
}