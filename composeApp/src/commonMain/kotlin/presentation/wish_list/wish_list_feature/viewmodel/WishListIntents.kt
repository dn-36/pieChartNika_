package org.example.project.presentation.wish_list.wish_list_feature.viewmodel

sealed class WishListIntents {
    object AddNewGoals:WishListIntents()
    object Back:WishListIntents()
    object SetScreen:WishListIntents()
    data class DetailGoal(val index:Int):WishListIntents()
}