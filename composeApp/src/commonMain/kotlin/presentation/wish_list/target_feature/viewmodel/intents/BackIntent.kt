package org.example.project.presentation.wish_list.target_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.target_feature.screen.TargetScreen
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel
import org.example.project.presentation.wish_list.wish_list_feature.screen.WishListScreen
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.WishListViewModel

object BackIntent {
    fun execute(){
        TargetViewModel(StaticDate).date.isUsedWishList.value = true
        StaticDate.navigator.push(WishListScreen)
    }
}