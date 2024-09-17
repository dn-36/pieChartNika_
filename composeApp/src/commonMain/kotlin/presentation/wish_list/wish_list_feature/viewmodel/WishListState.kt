package org.example.project.presentation.wish_list.wish_list_feature.viewmodel

import org.example.project.utils.Goal

data class WishListState(
    var listGoals:MutableList<Goal> = mutableListOf()
)
