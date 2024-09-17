package org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel
import org.example.project.presentation.wish_list.wish_list_feature.screen.WishListScreen

object BackIntent {
    fun execute(){
        TargetViewModel(StaticDate).date.isUsedWishList.value = true
        StaticDate.navigator.push(WishListScreen)
    }
}