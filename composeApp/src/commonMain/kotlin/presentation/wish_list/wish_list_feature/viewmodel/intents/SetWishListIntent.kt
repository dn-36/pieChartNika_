package org.example.project.presentation.wish_list.wish_list_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.WishListViewModel
import org.example.project.utils.Goal

object SetWishListIntent {
    fun execute(){
        if(WishListViewModel(StaticDate).date.isUsedWishList.value) {
            WishListViewModel(StaticDate).date.isUsedWishList.value = false
            var newList = mutableListOf<Goal>()
            for (y in WishListViewModel(StaticDate).date.listGoals) {
                if (y.already < y.sum) {
                    newList.add(y)
                }
            }
            WishListViewModel.wishListState = WishListViewModel.wishListState.copy(
                listGoals = newList
            )
        }
    }
}