package org.example.project.presentation.menu_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.FinishWishViewModel
import org.example.project.presentation.wish_list.wish_list_feature.screen.WishListScreen
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.WishListViewModel

object WishListIntent {
    fun execute(){
        MenuViewModel(StaticDate).date.isUsedWishList.value = true
        StaticDate.navigator.push(WishListScreen)
    }
}