package org.example.project.presentation.wish_list.finish_wish_feature.viewmodel

sealed class FinishWishIntents {
    object SetScreen:FinishWishIntents()
    object Done:FinishWishIntents()
}